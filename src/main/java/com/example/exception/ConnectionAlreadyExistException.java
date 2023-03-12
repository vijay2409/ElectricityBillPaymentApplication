package com.example.exception;

public class ConnectionAlreadyExistException extends RuntimeException{

    public ConnectionAlreadyExistException(String message){
        super(message);
    }
}
