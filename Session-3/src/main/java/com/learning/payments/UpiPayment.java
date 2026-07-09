package com.learning.payments;

public class UpiPayment implements Payment{

    @Override
    public void pay(double amount) {
        System.out.println("Paid using UPI " + amount );
    }
}
