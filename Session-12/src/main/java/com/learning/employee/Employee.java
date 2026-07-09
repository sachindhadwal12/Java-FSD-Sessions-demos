package com.learning.employee;

import com.learning.department.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Employee {

    private Department department;

    @Autowired
    public Employee( @Qualifier("hrDept") Department department){
        this.department = department;
        System.out.println("Employee Bean Created");

    }

    public void displayEmployeeInfo(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name");
        String name = scanner.next();
        System.out.println(name+"  "+ "Employee Department : "+ department.getDepartment());
    }

}
