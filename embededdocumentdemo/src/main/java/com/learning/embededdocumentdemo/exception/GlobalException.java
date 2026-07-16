package com.learning.embededdocumentdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(MedicineIdAlreadyExistException.class)
    public ResponseEntity<?> MedicineIdAlreadyExistException(MedicineIdAlreadyExistException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }
    @ExceptionHandler(MedicineIdNotFoundException.class)
    public ResponseEntity<?> MedicineIdNotFoundException(MedicineIdNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MedicineNameNotFoundException.class)
    public ResponseEntity<?> MedicineNameNotFoundException(MedicineNameNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
