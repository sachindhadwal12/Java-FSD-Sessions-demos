package com.learning.banking;

public class CurrentAccount extends BankAccount {
    double overdraft;

    public CurrentAccount(String accountNumber, String accountHolderName, double balance, double overdraft) {
        super(accountNumber, accountHolderName, balance);
        this.overdraft = overdraft;
    }

    void displayOverDraftLimit(){
        System.out.println("OverDraft limit " + overdraft);
    }
}
