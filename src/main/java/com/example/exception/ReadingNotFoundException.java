package com.example.exception;

public class ReadingNotFoundException extends RuntimeException{

    public ReadingNotFoundException(String message){
        super(message);
    }
}
