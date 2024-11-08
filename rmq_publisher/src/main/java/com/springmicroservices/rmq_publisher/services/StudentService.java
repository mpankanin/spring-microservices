package com.springmicroservices.rmq_publisher.services;

import com.springmicroservices.rmq_publisher.model.Notification;
import com.springmicroservices.rmq_publisher.model.Student;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StudentService {

    private final RestTemplate restTemplate;

    public StudentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Student getStudentNotification(long studentId) {
        return null;
    }

    public Notification sendStudentNotification(long studentId) {
        Student student = restTemplate.exchange("http://localhost:28080/students/" + studentId,
                HttpMethod.GET, HttpEntity.EMPTY, Student.class).getBody();
        return createNotification(student);
    }

    private Notification createNotification(Student student) {
        Notification notification = new Notification();
        notification.setEmail(student.getEmail());
        notification.setTitle("Witaj " + student.getName());
        notification.setBody("Nice that you are with us " + student.getName() + " " + student.getSurname());
        return notification;
    }
}
