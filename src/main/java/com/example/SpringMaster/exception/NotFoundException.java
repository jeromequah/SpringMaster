package com.example.SpringMaster.exception;

// Handles Error 404
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}