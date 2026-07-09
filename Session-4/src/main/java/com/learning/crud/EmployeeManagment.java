package com.learning.crud;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManagment {
    static void main() {
        List<Employee>  employeeList = new ArrayList<>();
//        add Employees

        employeeList.add(new Employee(101,"Sachin","IT"));
        employeeList.add(new Employee(102,"Mike","Sales"));
        employeeList.add(new Employee(103,"John","HR"));
        employeeList.add(new Employee(104,"Gopal","Marketing"));

        System.out.println("--------Employee List---------");
        for(Employee e: employeeList){
            System.out.println(e);
        }
        // Search Employee

        System.out.println("Searching for 102 empployee");
        for(Employee e: employeeList){
            if(e.getId()==102){
                System.out.println("Found" + e);
            }
        }

        // Remove Employee

        employeeList.remove(1);
        System.out.println("--------Employee List after Remove---------");
        for(Employee e: employeeList){
            System.out.println(e);
        }
    }
}
