package com.springmicroservices.student_app.service;

import com.springmicroservices.student_app.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    public Student getStudent(long studentId);

    public List<Student> getStudents();

    public List<Student> getStudents(String status);

    public Student addStudent(Student student);

}
