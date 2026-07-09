package com.learning.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ReadEmployee {
    static void main() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Employee emp = mapper.readValue(new File("employee.json"),Employee.class);

        System.out.println("Employee Id" + emp.getEmpId());
        System.out.println("Employee Name "+emp.getName());

    }
   }
