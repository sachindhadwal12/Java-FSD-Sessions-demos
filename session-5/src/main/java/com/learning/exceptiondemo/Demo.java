package com.learning.exceptiondemo;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Demo {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        int result;
        try{
        System.out.println("Enter the Number");
        int num = scanner.nextInt();
         result = num/0;
            System.out.println("The quotient is :"+ result);
        }
        catch (InputMismatchException | ArithmeticException exception)
        {
            System.out.println(Arrays.toString(exception.getStackTrace()) + "  "+exception.getMessage());
        }

        finally {
            System.out.println("I am finally block");
        }

    }
}
