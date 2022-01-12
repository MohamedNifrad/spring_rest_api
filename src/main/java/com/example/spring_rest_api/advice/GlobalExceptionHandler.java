package com.example.spring_rest_api.advice;

import com.example.spring_rest_api.exception.DoNotUseException;
import com.example.spring_rest_api.exception.EmptyInputException;
import com.example.spring_rest_api.exception.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.NoSuchElementException;


@CrossOrigin
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * custom Exception handling
     */
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?> handleNoSuchElementException(NoSuchElementException noSuchElementException) {
        return new ResponseEntity<>("No value is present in the database",HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DoNotUseException.class)
    public ResponseEntity<?> handleDoNotUseException(DoNotUseException doNotUseException) {
        return new ResponseEntity<>("this name is not acceptable", HttpStatus.NOT_ACCEPTABLE);
    }
    /**
     * end
     */

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>("please change your http method request type",status);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> handleNullPointerException(NullPointerException nullPointerException) {
        return new ResponseEntity<>("please change your request body", HttpStatus.NOT_ACCEPTABLE);
    }

    //global exception handle
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) {
        //ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>("internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<?> handleEmptyInput(EmptyInputException emptyInputException) {
        return new ResponseEntity<>("Input field is Empty", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NotFoundException.class, EntityNotFoundException.class})
    public ResponseEntity<?> handleNotFoundException(Exception e) {
        return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
    }
}
