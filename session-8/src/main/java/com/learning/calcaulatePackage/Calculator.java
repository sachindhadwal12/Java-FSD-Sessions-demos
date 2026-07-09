package com.learning.calcaulatePackage;

public class Calculator {
    public int add(int a, int b){
        return a + b;

    }
    public int subtract(int a, int b){
        return a - b;
    }
    public int multiply(int a, int b){
        return a * b;
    }
    public int divide(int a, int b){
        return a / b;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = calculator.divide(10,0);
        System.out.println(result);
    }
}
