package com.learning;

public class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
