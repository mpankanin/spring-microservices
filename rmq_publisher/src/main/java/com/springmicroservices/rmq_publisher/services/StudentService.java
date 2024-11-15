package com.springmicroservices.rmq_publisher.services;

import com.springmicroservices.rmq_publisher.model.Notification;
import com.springmicroservices.rmq_publisher.model.Student;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StudentService implements{

    private final RestTemplate restTemplate;
    private final RabbitTemplate rabbitTemplate;

    public StudentService(RestTemplate restTemplate, RabbitTemplate rabbitTemplate) {
        this.restTemplate = restTemplate;
        this.rabbitTemplate = rabbitTemplate;
    }

    public Notification sendStudentNotification(long studentId) {
        Student student = restTemplate.exchange("http://localhost:28080/students/" + studentId,
                HttpMethod.GET, HttpEntity.EMPTY, Student.class).getBody();
        Notification notification = createNotification(student);
        rabbitTemplate.convertAndSend("notification", notification);
        return notification;
    }

    private Notification createNotification(@Nullable Student student) {
        Notification notification = new Notification();
        if (student != null) {
            notification.setEmail(student.getEmail());
            notification.setTitle("Witaj " + student.getName());
            notification.setBody("Nice that you are with us " + student.getName() + " " + student.getSurname());
        } else {
            notification.setBody("Nothing to set, no student's data was provided");
        }
        return notification;
    }

}
