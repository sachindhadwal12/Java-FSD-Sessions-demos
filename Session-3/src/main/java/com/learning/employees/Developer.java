package com.learning.employees;

public class Developer extends Employee{

    public Developer(String name, int empId) {
        super(name, empId);
    }

    @Override
    public void work() {
        System.out.println(name+" is writing Java Code");
    }
}
