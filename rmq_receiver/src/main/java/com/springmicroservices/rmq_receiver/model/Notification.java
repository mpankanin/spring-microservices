package com.springmicroservices.rmq_receiver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification /*implements Serializable - json bean instead*/ {

    private String email;
    private String title;
    private String body;

    @Override
    public String toString() {
        return "Notification to : " + email + ", about:" + title + ", body: " + body;
    }

}
