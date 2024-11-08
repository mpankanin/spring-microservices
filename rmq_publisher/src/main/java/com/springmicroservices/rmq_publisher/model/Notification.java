package com.springmicroservices.rmq_publisher.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {

    private String email;
    private String title;
    private String body;

}
