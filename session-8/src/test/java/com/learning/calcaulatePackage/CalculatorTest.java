package com.learning.calcaulatePackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
        System.out.println("Before each method");
    }

    @Test
    public  void shouldReturnSumOfTwoNumber(){
        int result = calculator.add(4,8);
        assertEquals(12,result);
    }
    @Test
    public void shouldReturnPostiveValueWhenOneNumberisNegative(){
        int result = calculator.add(10,-5);
        assertEquals(5,result);
    }

    @Test
    public void shouldThrowExceptionWhenDivideByZeroNumberisGiven(){
        assertThrows(ArithmeticException.class,()-> {
            calculator.divide(10,0);
        });
    }

}