package com.springmicroservices.student_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StudentAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentAppApplication.class, args);
    }

}
