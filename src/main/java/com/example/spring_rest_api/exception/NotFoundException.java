package com.example.spring_rest_api.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(Throwable cause) {
        super(cause);
    }
}
