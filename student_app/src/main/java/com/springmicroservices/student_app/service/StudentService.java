package com.springmicroservices.student_app.service;

import com.springmicroservices.student_app.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student getStudent(long studentId);

    List<Student> getStudents();

    List<Student> getStudents(String status);

    Student addStudent(Student student);

    void deleteStudent(long studentId);

}
