package com.springmicroservices.rmq_receiver.services;

import com.springmicroservices.rmq_receiver.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQReceiver {

    @RabbitListener(queues = "notification")
    public void print(Notification notification) {
        System.out.println(notification);
    }

}
