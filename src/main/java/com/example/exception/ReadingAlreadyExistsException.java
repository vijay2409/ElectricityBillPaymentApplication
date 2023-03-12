package com.example.exception;

public class ReadingAlreadyExistsException extends RuntimeException{

    public ReadingAlreadyExistsException (String message){
        super(message);
    }
}
