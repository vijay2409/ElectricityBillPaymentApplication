package com.example.exception;

public class CustomerAlreadyFoundException extends RuntimeException{

    public CustomerAlreadyFoundException(String message) {
        super(message);
    }
}
