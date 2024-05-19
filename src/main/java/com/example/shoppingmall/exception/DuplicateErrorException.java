package com.example.shoppingmall.exception;

public class DuplicateErrorException extends Exception{
    private String message;

    public DuplicateErrorException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
