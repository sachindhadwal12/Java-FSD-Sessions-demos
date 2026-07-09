package com.learning.mapdemo;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class EmployeeManagement {
    static void main() {
//        Map<Integer,Employee> employeeMap = new HashMap<>();
//        employeeMap.put(101, new Employee(101,"Sachin","IT",39999));
//        employeeMap.put(102, new Employee(102,"Priya","Sales",40000));
//        employeeMap.put(103, new Employee(103,"Mohit","HR",50000));
//        employeeMap.put(104, new Employee(104,"Rohit","IT",60000));
//
//        // find employee id 102
//
//        Employee emp = employeeMap.get(102);
//        System.out.println(emp);

        Stack<Employee> employeeStack = new Stack<>();
        employeeStack.push(new Employee(101,"Sachin","IT",34000));
        employeeStack.push(new Employee(102,"Mohit","sales",34000));
        employeeStack.push(new Employee(103,"Rohit","HR",34000));
        employeeStack.push(new Employee(104,"Sahil","IT",34000));

        // remove the last value

        Employee removeEmployee = employeeStack.pop();
        System.out.println(removeEmployee);

        System.out.println(employeeStack.peek());
    }
}
