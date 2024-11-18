package com.springmicroservices.student_app.service;

import com.springmicroservices.student_app.exception.PatchException;
import com.springmicroservices.student_app.exception.student.StudentNotFoundException;
import com.springmicroservices.student_app.model.Student;
import com.springmicroservices.student_app.repository.StudentRepository;
import com.springmicroservices.student_app.util.Patcher;
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
    public Student getStudent(long studentId) throws StudentNotFoundException {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id:" + studentId));
        if (Student.Status.INACTIVE.equals(student.getStatus())) {
            throw new IllegalStateException("The student's status is inactive");
        }
        return student;
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
        student.setStatus(Student.Status.INACTIVE);
        studentRepository.save(student);
    }

    @Override
    public Student updateStudent(long studentId, Student student) {
        Student existingStudent = getStudent(studentId);

        existingStudent.setName(student.getName());
        existingStudent.setSurname(student.getSurname());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setStatus(student.getStatus());

        return studentRepository.save(existingStudent);
    }

    @Override
    public Student updateStudentByFields(long studentId, Student student) {
        Student existingStudent = getStudent(studentId);
        try {
            Patcher.patch(existingStudent, student);
        } catch (IllegalAccessException e) {
            throw new PatchException("Couldn't patch a student: " + studentId);
        }
        return studentRepository.save(existingStudent);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getStudents(String status) {
        return studentRepository.findAllByStatus(Student.Status.valueOf(status));
    }

    private void validateStudentEmail(String email) throws DataIntegrityViolationException {
        boolean emailExists = studentRepository.existsByEmail(email);
        if (emailExists) {
            throw new DataIntegrityViolationException("Provided student's email already exists.");
        }
    }

}
