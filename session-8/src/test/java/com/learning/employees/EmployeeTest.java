package com.learning.employees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {


    @Test
    public void testEmployeeID(){
        Employee emp = new Employee(101,"Sachin",30000);
        int id = emp.getId();
        assertEquals(101,id);
    }

}