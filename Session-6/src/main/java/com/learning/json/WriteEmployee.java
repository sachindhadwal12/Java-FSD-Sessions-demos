package com.learning.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;

public class WriteEmployee {
    static void main() throws IOException {
        Employee emp = new Employee(101,"Sachin","IT",4000);
        ObjectMapper mapper = new ObjectMapper();
         mapper.writerWithDefaultPrettyPrinter().
                 writeValue(new File("employee.json"),emp);
        System.out.println("JSON file created");
    }
}
