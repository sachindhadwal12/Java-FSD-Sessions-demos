package com.learning.payments;

public class NetBanking implements Payment{
    @Override
    public void pay(double amount) {
        System.out.println("Paid Using Net Banking:"+ amount);
    }
}
