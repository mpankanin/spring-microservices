package com.springmicroservices.student_app.exception.student;

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(String message) {
        super(message);
    }

}