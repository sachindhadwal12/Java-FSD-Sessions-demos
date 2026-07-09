package com.learning.employees;

public abstract class Employee {
    String name;
    int empId;

    public Employee(String name, int empId) {
        this.name = name;
        this.empId = empId;
    }

    // Abstract
    public abstract void work();

//concrete
    public void login() {
        System.out.println(name +" logged into the system.");
    }
}