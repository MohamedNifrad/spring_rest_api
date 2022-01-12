package com.example.spring_rest_api.exception;

public class DoNotUseException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public DoNotUseException(String message) {
        super(message);
    }

    public DoNotUseException() {
    }
}
