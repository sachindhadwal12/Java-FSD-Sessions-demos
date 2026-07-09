package com.learning;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
   String name;
    int age;
    Main(){
        System.out.println("I am constructor");
    }

    Main(String name, int age){

        this.name= name;
        this.age = age;
    }

    void acceptData(){

    }

    public void displayData(){
        System.out.println("Name is "+ name);
        System.out.println("Age is "+ age);
    }

    public static void main(String[] args) {

        Main  main1 = new Main();
        Main  main = new Main("Sachin",77);
        main.displayData();


//        int [][] matrix = new int[2][2];
//        matrix[0][0]=2;
//        matrix[0][1]=3;
//        matrix[1][0]=4;
//        matrix[1][1]=5;
//
//       for(int i=0;i<matrix.length;i++){
//           for(int j=0;j<matrix[i].length;j++){
//               System.out.print(matrix[i][j]);
//           }
//           System.out.println();
//       }

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter rows");
//        int rows = scanner.nextInt();
//        System.out.println("Enter Columns");
//        int columns = scanner.nextInt();
//
//        int [][] matrix = new int[rows][columns];
//
//        System.out.println("Enter the matrix values");
//
//        for(int i=0;i<rows;i++){
//            for(int j=0;j<columns;j++){
//                matrix[i][j] = scanner.nextInt();
//            }
//        }
//        System.out.println("=========================================");
//
//        for(int i=0;i<rows;i++){
//            for(int j=0;j<columns;j++){
//                System.out.print(matrix[i][j]+"  ");
//            }
//            System.out.println();
//        }

        int [] arr = {12,45,8,90,32};
        int max = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        System.out.println("Largest "+ max);







     }
}
