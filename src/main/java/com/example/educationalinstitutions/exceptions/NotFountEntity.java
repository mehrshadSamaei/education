package com.example.educationalinstitutions.exceptions;
// handler 500 or 400 error
public class NotFountEntity extends RuntimeException{
    public NotFountEntity(String message) {
        super(message);
    }
}
