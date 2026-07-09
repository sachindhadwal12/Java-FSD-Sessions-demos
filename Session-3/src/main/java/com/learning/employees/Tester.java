package com.learning.employees;

public class Tester extends Employee{


    public Tester(String name, int empId) {
        super(name, empId);
    }

    @Override
    public void work() {
        System.out.println(name+" is testing the application");
    }
}
