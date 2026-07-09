package com.learning.Demos;

 interface  MyData{
//     public default void getData() {
//         System.out.println("My Data Method");
//     }
     public void getData();
     public default void hello(){
         System.out.println(" I am a default method");
     }

 }


public class MyDemo  {

    public static void main(String[] args) {
        MyData data = () -> System.out.println(" I am data Method");
        data.getData();
        data.hello();
    }


}
