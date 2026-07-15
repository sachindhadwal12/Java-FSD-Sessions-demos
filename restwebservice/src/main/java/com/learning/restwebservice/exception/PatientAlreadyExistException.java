package com.learning.restwebservice.exception;

public class PatientAlreadyExistException extends Exception{
    public PatientAlreadyExistException(String message) {
        super(message);
    }
}
