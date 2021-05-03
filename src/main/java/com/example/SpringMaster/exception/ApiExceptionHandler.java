package com.example.SpringMaster.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

// Handles > 1 Exception
@ControllerAdvice // To allow class to be used throughout whole application for exceptions
public class ApiExceptionHandler {

    @ExceptionHandler(value = ApiRequestException.class) // to handle more than 1 exception
    public ResponseEntity<Object> handleApiRequestException(
            ApiRequestException e // takes exception that is going to handle
    ) {
//        Payload for Client
        ApiException apiException = new ApiException(
                e.getMessage(),
                e,
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now()
        );
//        Send Response
        return new ResponseEntity<>(
                apiException,
                HttpStatus.BAD_REQUEST);
    }
}
