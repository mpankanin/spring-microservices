package com.springmicroservices.student_app.controller;

import com.springmicroservices.student_app.model.Student;
import com.springmicroservices.student_app.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<Student> getStudent(long studentId) {
        Optional<Student> optionalStudent = studentService.getStudent(studentId);
        return optionalStudent.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
