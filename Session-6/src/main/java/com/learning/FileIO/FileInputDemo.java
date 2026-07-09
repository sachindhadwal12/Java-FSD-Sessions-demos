package com.learning.FileIO;

import java.io.*;
import java.sql.SQLOutput;

public class FileInputDemo {
    static void main() throws IOException {
//        FileInputStream fis = new FileInputStream("hello.txt");
//        int data;
//        while((data = fis.read())!=-1){
//            System.out.print((char) data);
//        }
//        fis.close();

//        FileOutputStream fos = new FileOutputStream("hello.txt");
//        String name = "We are not leaning any Sachin";
//        byte[] myData = name.getBytes();
//        fos.write(myData);
//        fos.close();
//        System.out.println("Data written Successfully");

//        FileWriter fw = new FileWriter("hello.txt");
//        String name = "Happy Learning";
//        fw.write(name);
//        fw.close();
//        System.out.println("Data written Successfully");

        FileReader fr = new FileReader("hello.txt");
        int data;
        while((data = fr.read()) != -1){
            System.out.print((char) data);
        }
      fr.close();

    }
}
