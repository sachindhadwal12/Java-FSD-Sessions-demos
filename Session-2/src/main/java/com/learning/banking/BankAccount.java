package com.learning.banking;

public class BankAccount {
    String accountNumber;
    String accountHolderName;
    double balance;


    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    void deposit(double amount){
        balance+=amount;
        System.out.println("Amount credited :"+ amount);
    }

    void withdraw(double amount){
        balance -=amount;
        System.out.println("Amount debited:"+ amount);
    }

    void displayAccountInfo(){
        System.out.println("Account Number "+accountNumber);
        System.out.println("Account Holder "+ accountHolderName);
        System.out.println("Balance "+ balance);
    }
}
