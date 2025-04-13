package com.java.planning.book.endpoint.exception;

import com.java.planning.book.entity.entityHelper.ErrorMessage;
import com.java.planning.book.service.exception.BookException;
import com.java.planning.book.service.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ExceptionHandlerApp {

    @ExceptionHandler (value = {
            BookException.BookNotFoundException.class
    })
    public ResponseEntity<ErrorMessage> notFoundException(RuntimeException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                HttpStatus.NOT_FOUND,
                ex.getMessage());
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler (value = {
            BookException.BookAlreadyExistException.class
    })
    public ResponseEntity<ErrorMessage> alreadyExistException(RuntimeException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.CONFLICT.value(),
                new Date(),
                HttpStatus.CONFLICT,
                ex.getMessage());
        return new ResponseEntity<>(message, HttpStatus.CONFLICT);
    }

    @ExceptionHandler (value = {
            GeneralException.UnHandledException.class
    })
    public ResponseEntity<ErrorMessage> unHandledException(RuntimeException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new Date(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getMessage());
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
