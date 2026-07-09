package com.learning.Java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

//@FunctionalInterface
//interface Calculator{
//    int add(int a, int b);
//}


interface Message{
    void getData();
}


public class App{

    App(){
        System.out.println("I am a constructor");
    }

//    public   void MyData(){
//        System.out.println(" I am a static method");
//    }



    public static void main(String[] args) {

     //   App app = new App();
//        Message message = app::MyData;
//        message.getData();

        Message msg = App::new;
        msg.getData();






//        Google google = () -> System.out.println("I am a search method");
//        google.search();

//        Calculator calculator = (a,b)-> a + b;
//        System.out.println(calculator.add(10,20));
//
//
//        Predicate<Integer> even = n -> n % 2==0;
//        System.out.println(even.test(10));


        List<String> list = new ArrayList<>();
        list.add("Sachin");
        list.add("Gopal");
        list.add("Mukesh");

//        for(String val : list){
//            System.out.println(val);
//        }

//        list.forEach(name -> System.out.println(name));
        list.forEach(System.out::println);
    }
}
