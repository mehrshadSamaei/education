package com.example.educationalinstitutions.exceptions;

public class BadRequestClient extends RuntimeException{
    public BadRequestClient(String message, Throwable cause) {
        super(message, cause);
    }

    public BadRequestClient(String message) {
        super(message);
    }
}
