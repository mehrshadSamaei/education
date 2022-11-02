package com.example.educationalinstitutions.exceptions;

import org.hibernate.exception.DataException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class RestExceptionHandler {
        @ExceptionHandler(value = {NotFountEntity.class})
    public ResponseEntity<ExceptionData> notFoundEx(NotFountEntity ex){
            ExceptionData data = new ExceptionData(
                    ex.getMessage(), ex
                    , HttpStatus.NOT_FOUND, ZonedDateTime.now(ZoneId.of("Z"))
            );
            return new ResponseEntity<>(data , HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = {BadRequestClient.class})
    public ResponseEntity<ExceptionData> badRequestClient(BadRequestClient ex){
        ExceptionData data = new ExceptionData(
                ex.getMessage(), ex, HttpStatus.BAD_REQUEST, ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(data , HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = {AccessException.class})
    public ResponseEntity<ExceptionData> accessException(AccessException ex){
        ExceptionData data = new ExceptionData(
                ex.getMessage(), ex, HttpStatus.FORBIDDEN, ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(data , HttpStatus.FORBIDDEN);
    }

}
