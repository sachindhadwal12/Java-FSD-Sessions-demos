package com.learning.NIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FilesDemo {
    static void main() throws IOException {
       Path source = Paths.get("Learning/.citidata");

       if(!Files.exists(source)){
           Files.createFile(source);
           System.out.println("Hidden file is created");
       }

        System.out.println(Files.isHidden(source));

       // System.out.println(Files.size(source));


       // Path  target = Paths.get("Learning/copy.txt");


       // Files.delete(target);

        //Files.copy(source,target, StandardCopyOption.REPLACE_EXISTING);


//
//        String data  = Files.readString(path);
//        System.out.println(data);

//        if(!Files.exists(path)){
//            Files.createFile(path);
//            System.out.println("File Created");
//            String data = "Welcome to Java NIO";
//            Files.write(path,data.getBytes());
//        }
//        else {
//            System.out.println("File Already Exists");
//        }

    }
}
