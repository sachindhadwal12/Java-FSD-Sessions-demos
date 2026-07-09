package com.learning.employees;

public class Department {
    static void main() {
        Employee employee = new Developer("Sachin",101);
        Employee employee1 = new Tester("Sahil",102);
      employee.login();
      employee.work();
        employee1.login();
        employee1.work();

    }
}
