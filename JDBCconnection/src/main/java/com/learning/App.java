package com.learning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
       String url = "jdbc:mysql://localhost:3306/employeeDB";
       String username = "root";
       String password = "root@123";

        Connection connection = DriverManager.getConnection(url,username,password);
        PreparedStatement ps = connection.prepareStatement("Insert into employee(id, name, salary) values (?,?,?)");
        ps.setInt(1,101);
        ps.setString(2,"Sachin");
        ps.setDouble(3,40000);
        int rows = ps.executeUpdate();
        System.out.println("Data Saved Successfully");
    }
}
