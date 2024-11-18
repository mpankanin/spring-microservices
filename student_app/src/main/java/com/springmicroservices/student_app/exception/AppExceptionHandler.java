package com.springmicroservices.student_app.exception;

import com.springmicroservices.student_app.exception.student.StudentNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorEntity> handleException(StudentNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ErrorEntity(e.getMessage())
        );
    }

    @ExceptionHandler ResponseEntity<ErrorEntity> handleException(DataIntegrityViolationException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                new ErrorEntity(e.getMessage())
        );
    }

    @ExceptionHandler ResponseEntity<ErrorEntity> handleException(IllegalStateException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ErrorEntity(e.getMessage())
        );
    }

}
