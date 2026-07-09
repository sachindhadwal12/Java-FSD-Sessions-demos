package com.learning;

import java.sql.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
   public static void main(String [] abc) throws SQLException, ClassNotFoundException {
       // Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/employeeDB";
        String username = "root";
        String password = "root@123";

        Connection connection = DriverManager.getConnection(url,username,password);

        String query = "select * from employee";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
             int id = rs.getInt("id");
             String name = rs.getString("name");
             double salary = rs.getDouble("salary");
             System.out.println( id +"   "+ name +"  "+ salary);
        }



//        PreparedStatement ps = connection.prepareStatement("Insert into employee(id, name, salary) values (?,?,?)");
//        ps.setInt(1,106);
//        ps.setString(2,"Rahul");
//        ps.setDouble(3,80000);
//        int rows = ps.executeUpdate();
//        System.out.println("Data Saved Successfully");


    }
}
