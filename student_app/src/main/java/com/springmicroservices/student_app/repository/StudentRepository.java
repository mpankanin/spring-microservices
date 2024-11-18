package com.springmicroservices.student_app.repository;

import com.springmicroservices.student_app.model.Student;
import com.springmicroservices.student_app.model.StudentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByEmail(String email);

    List<Student> findAllByStatus(StudentStatus status);

}
