package com.learning;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Student std = context.getBean(Student.class);
        System.out.println(std);


    }
}
