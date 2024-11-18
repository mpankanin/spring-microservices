package com.springmicroservices.student_app.service;

import com.springmicroservices.student_app.exception.student.StudentNotFoundException;
import com.springmicroservices.student_app.model.Student;

import java.util.List;

public interface StudentService {

    Student getStudent(long studentId) throws StudentNotFoundException;

    List<Student> getStudents();

    List<Student> getStudents(String status);

    Student addStudent(Student student);

    void deleteStudent(long studentId) throws StudentNotFoundException;

}
