package com.learning.Demos;

import java.util.Arrays;
import java.util.List;

public class EmployeeRepository {
    public static List<Employee> getData(){
        return Arrays.asList(new Employee(101,"Aarav","Engineering",125000),
                new Employee(102,"Isha","Engineering",99000),
                new Employee(103,"Ravi","HR",91000),
                new Employee(104,"Meera","Finance",66000),
                new Employee(105,"Karan","Engineering",77000),
                new Employee(106,"Pooja","Finance",50000),
                new Employee(107,"Anuj","HR",95000),
                new Employee(108,"Sneha","Engineering",70000),
                new Employee(109,"Vikas","Sales",18000),
                new Employee(110,"Gopal","Sales",8000),
                new Employee(111,"Sameer","Engineering",98000),
                new Employee(112,"Neha","Engineering",60000)
                );
    }
}
