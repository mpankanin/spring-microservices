package com.springmicroservices.student_app.exception;

public class ErrorEntity {

    private String message;

    public ErrorEntity(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
