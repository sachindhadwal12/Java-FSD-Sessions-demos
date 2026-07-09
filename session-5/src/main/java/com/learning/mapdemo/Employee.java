package com.learning.mapdemo;

public class Employee {
    private int empId;
    private String name;
    private String department;
    private double salary;

    public Employee(int empId, String name, String department, double salary) {
        this.empId = empId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
