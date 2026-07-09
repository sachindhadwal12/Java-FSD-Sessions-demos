package com.learning.exceptiondemo;

public class InvalidSalaryException extends Exception{
    InvalidSalaryException(String msg){
        super(msg);
    }
}
