package com.example.exception;

public class BillNotFoundException extends RuntimeException{

    public BillNotFoundException(String message){
        super(message);
    }
}
