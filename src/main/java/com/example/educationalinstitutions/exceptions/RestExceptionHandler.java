package com.example.educationalinstitutions.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = NotFountEntity.class)
    public ResponseEntity<ExceptionData> notFoundEx(NotFountEntity notFountEntity) {
        return new ResponseEntity<>(new ExceptionData(notFountEntity.getMessage()), HttpStatus.NOT_FOUND);
    }
}
