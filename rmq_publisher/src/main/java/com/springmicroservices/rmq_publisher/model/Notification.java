package com.springmicroservices.rmq_publisher.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification /*implements Serializable - json bean instead*/ {

    private String email;
    private String title;
    private String body;

}
