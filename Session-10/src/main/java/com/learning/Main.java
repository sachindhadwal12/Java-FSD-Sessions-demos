package com.learning;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

//        Hobby hobby = new Hobby("Cricket","02-04-2003");
//        Student student = new Student("Sachin","sachin@gmail.com",hobby);
//        System.out.println(student);

       // ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
       AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student std = context.getBean("std",Student.class);
        Student std1 = context.getBean("std",Student.class);
        context.registerShutdownHook();
        System.out.println(std);

        if (std == std1){
            System.out.println("Same Object");
        }
        else {
            System.out.println("Not same object");
        }






    }
}
