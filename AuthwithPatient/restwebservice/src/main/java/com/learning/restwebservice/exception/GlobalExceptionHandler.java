package com.learning.restwebservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PatientAlreadyExistException.class)
    public ResponseEntity<?> patientIdAlreadyExistException(PatientAlreadyExistException exception){
       return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(PatientIdNotFoundException.class)
    public ResponseEntity<?> patientIdNotFoundException(PatientIdNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidations(MethodArgumentNotValidException exception){
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach(
                (error)->{
                    String fieldName = ((FieldError)error).getField();
                    String errMsg = error.getDefaultMessage();
                    errors.put(fieldName,errMsg);
                }
        );
        return errors;
    }
}
