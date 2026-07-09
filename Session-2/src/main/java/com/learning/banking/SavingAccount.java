package com.learning.banking;

public class SavingAccount  extends BankAccount{

    double intersetRate;

    public SavingAccount(String accountNumber, String accountHolderName, double balance, double intersetRate) {
        super(accountNumber, accountHolderName, balance);
        this.intersetRate = intersetRate;
    }
    void calculateIntersetRate(){
        double interest = balance * intersetRate/100;
        System.out.println("Interest Gained "+interest);
    }
}
