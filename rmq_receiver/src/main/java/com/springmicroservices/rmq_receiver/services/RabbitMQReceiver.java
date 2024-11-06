package com.springmicroservices.rmq_receiver.services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class RabbitMQReceiver {

    @RabbitListener(queues = "test")
    public void print(String message) {
        System.out.println(message);
    }

}
