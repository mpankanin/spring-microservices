package com.springmicroservices.rmq_publisher.controllers;

import com.springmicroservices.rmq_publisher.model.Notification;
import com.springmicroservices.rmq_publisher.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<Notification> sendStudentNotification(@RequestParam long studentId) {
        Notification notification = studentService.sendStudentNotification(studentId);
        return ResponseEntity.ok(notification);
    }

}
