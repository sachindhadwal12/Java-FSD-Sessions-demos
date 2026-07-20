package com.learning.doctor_patient_demo.exception;

public class DoctorNotFoundException extends RuntimeException{
    public DoctorNotFoundException(String msg){
        super(msg);
    }
}
