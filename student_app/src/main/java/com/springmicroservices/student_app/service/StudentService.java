package com.springmicroservices.student_app.service;

import com.springmicroservices.student_app.model.Student;
import com.springmicroservices.student_app.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Optional<Student> getStudent(long studentId) {
        return studentRepository.findById(studentId);
    }

}
