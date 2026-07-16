package com.learning.embededdocumentdemo.exception;

public class MedicineIdAlreadyExistException extends Exception{
    public MedicineIdAlreadyExistException(String message) {
        super(message);
    }
}
