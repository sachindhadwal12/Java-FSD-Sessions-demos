package com.learning;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        String [] names = new String[5];
        System.out.println("Enter names");
        for(int i=0;i< names.length;i++){
            names[i]= scanner.next();
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        for(String n : names){
            System.out.println(n);
        }










//
//        String [] name = {"Sachin","Gopal","Ramesh","Vishal"};

//        for(int i=0;i< name.length;i++){
//            System.out.println(name[i]);
//        }

//        for(String n : name){
//            System.out.println(n);
//        }













//        int age = 14;
//        if(age >= 18) {
//            System.out.println("Eligilbe to vote");
//        }
//        else {
//            System.out.println("Not Eligible to vote");
//        }


//        int i=10;
//        do{
//            System.out.println(i);
//            i++;
//        }while (i<=5);



//        System.out.println("Enter the number");
//        int num1 = scanner.nextInt();
//        int i=11;
//        while(i<=10){
//            System.out.println(num1 +" X "+ i + " = " + num1*i);
//            i++;
//        }

//        int i=1;
//        while(i<=5){
//            System.out.println(i);
//            i++;
//        }






//
//        for(int i=1;i<=10;i++){
//            System.out.println(num1 + " * " + i + " = "+ num1*i);
//        }


//        for(int i=0;i<=5;i++){
//            System.out.println(i);
//        }
//int sum=0;
//         for(int i=1;i<=10;i++){
//             sum+=i;
//         }
//        System.out.println("The sum of 10 number is "+sum);
//






//        System.out.println("Enter the Operation");
//        String opt = scanner.next();
//        System.out.println("Enter the number 1");
//        int num1 = scanner.nextInt();
//        System.out.println("Enter the number 2");
//        int num2 = scanner.nextInt();
//        switch (opt){
//            case "+":
//                int result = num1 + num2;
//                System.out.println("The sum of two number is :"+ result);
//                break;
//            case "-":
//                int result1 = num1 - num2;
//                System.out.println("The minus of two number is :"+ result1);
//                break;
//            case "*":
//                int result2 = num1 * num2;
//                System.out.println("The product of two number is :"+ result2);
//                break;
//            case "/":
//                int result3 = num1 / num2;
//                System.out.println("The division of two number is :"+ result3);
//                break;
//            default:
//                System.out.println("Invalid Option");
//        }





       // System.out.println("Enter the number 1");
//        int num1 = scanner.nextInt();
//        System.out.println("Enter the number 2");
//        int num2 = scanner.nextInt();
//        System.out.println("Enter the number 3");
//        int num3 = scanner.nextInt();

//        if(num1==num2 && num2==num3){
//            System.out.println("All numbers are equal");
//        } else if (num1>=num2 && num1>=num3) {
//            System.out.println("Number 1 is greater");
//        } else if (num2 >= num1 && num2>= num3) {
//            System.out.println("Number 2 is greater");
//
//        }
//        else {
//            System.out.println("Number 3 is greater");
//        }


//        System.out.println("Enter the marks");
//        int num = scanner.nextInt();
//        if(num >=90){
//            System.out.println("Grade A");
//        } else if (num >= 75) {
//            System.out.println("Grade B");
//        } else if (num >=60) {
//            System.out.println("Grade C");
//        }
//        else {
//            System.out.println("Fail");
//        }


//        if(num % 2==0){
//            System.out.println("Number is Even");
//        }
//        else {
//            System.out.println("Number is odd");
//        }



    }
}
