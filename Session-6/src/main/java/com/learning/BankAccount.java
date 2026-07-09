package com.learning;

public class BankAccount {
    private  double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if(amount > balance){
            throw new InsufficientBalanceException("Insufficient Balance Avaialable !!! "+balance);
        }
        balance -= amount;
        System.out.println("Withdrawal Successful");
        System.out.println("Remaining Balance is :"+ balance);
    }
}

