package com.learning.setdemo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeSetOperation {
    static void main() {
        Set<Employee> employeeSet = new HashSet<>();
        employeeSet.add(new Employee(101, "Rahul", 40000));
        employeeSet.add(new Employee(102, "Priya", 50000));
        employeeSet.add(new Employee(103, "Sachin", 60000));
        employeeSet.add(new Employee(102, "Priya", 40000));


        System.out.println("===========Employees Details============");
        for (Employee e : employeeSet) {
            System.out.println(e);
        }


        System.out.println("Searching for 102 empployee");
        for (Employee e : employeeSet) {
            if (e.getId() == 102) {
                System.out.println("Found" + e);
            }
        }


    }

}
