package com.example.demo.exceptions;

public class AlreadyExistException extends RuntimeException{

    public AlreadyExistException(String message) {
        super(message);
    }
}
