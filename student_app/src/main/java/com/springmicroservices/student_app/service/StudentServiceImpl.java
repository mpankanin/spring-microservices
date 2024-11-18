package com.springmicroservices.student_app.service;

import com.springmicroservices.student_app.exception.student.StudentNotFoundException;
import com.springmicroservices.student_app.model.Student;
import com.springmicroservices.student_app.model.StudentStatus;
import com.springmicroservices.student_app.repository.StudentRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student getStudent(long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id:" + studentId));
    }

    @Override
    public Student addStudent(Student student) {
        validateStudentEmail(student.getEmail());
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(long studentId) throws StudentNotFoundException{
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Provided student's id does not exist."));
        student.setStatus(StudentStatus.INACTIVE);
        studentRepository.save(student);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getStudents(String status) {
        StudentStatus studentStatus = StudentStatus.fromString(status);
        return studentRepository.findAllByStatus(studentStatus);
    }

    private void validateStudentEmail(String email) throws DataIntegrityViolationException {
        Student student = studentRepository.findByEmail(email);
        if (student != null) {
            throw new DataIntegrityViolationException("Provided student's email already exists.");
        }
    }

}
