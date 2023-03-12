package com.example.exception;

public class ConnectionNotFoundException extends RuntimeException{

    public ConnectionNotFoundException(String message){
        super(message);
    }
}
