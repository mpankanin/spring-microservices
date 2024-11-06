package com.springmicroservices.rmq_publisher.controllers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbitmq")
public class RabbitMQController {

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/message")
    public ResponseEntity<String> sendMessage(@RequestParam String message, @RequestParam String routingKey) {
        rabbitTemplate.convertAndSend(routingKey, message);
        return ResponseEntity.ok(message);
    }

}
