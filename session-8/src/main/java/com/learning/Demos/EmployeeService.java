package com.learning.Demos;

import com.learning.Demos.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeService {

    public static void main(String[] args) {

        List<Employee> employeeList = EmployeeRepository.getData();

//        double highestSalary = employeeList.stream().map(Employee::getSalary)
//                .max(Double::compare)
//                .orElse(0.0);
//        System.out.println(highestSalary);
//
//        List<Employee> engDepartment = employeeList.stream()
//                .filter(employee -> employee.getDepartment().equals("Engineering")).collect(Collectors.toList());
//
//       for(Employee obj : engDepartment){
//           System.out.println(obj);
//       }
        // Filter All Engineering employees earning > 90000


//        List<Employee> engineerSalary = employeeList.stream()
//                .filter(e -> "Engineering".equalsIgnoreCase(e.getDepartment()))
//                .filter(e -> e.getSalary() > 90000).collect(Collectors.toList());
//        System.out.println(engineerSalary);


// average salary per department

        Map<String,Double> avgSalaryPerDept = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(avgSalaryPerDept);





    }
}
