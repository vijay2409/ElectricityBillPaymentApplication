package com.example.exception;

public class UserAlreadyFoundException extends RuntimeException{

    public UserAlreadyFoundException(String message){
        super(message);
    }
}
