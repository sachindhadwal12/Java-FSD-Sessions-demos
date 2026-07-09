package com.learning.exceptiondemo;

public class Employee {

    public static  void validateSalary(double salary) throws InvalidSalaryException {
        if(salary < 10000){
            throw  new InvalidSalaryException("Salary must be greater then 10000");
        }
        System.out.println("Salary is valid");
    }

    static void main() {
        try {
            validateSalary(14000);
        }catch (InvalidSalaryException e){
            System.out.println(e.getMessage());
        }
    }


}
