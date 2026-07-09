package com.learning.banking;

public class BankingApp {
    public static void main(String[] args) {
        SavingAccount savingAccount = new SavingAccount("SB001",
                "Sachin",10000,5);

        CurrentAccount  currentAccount = new CurrentAccount("CA002",
                "Gopal",5555555,5000);

        System.out.println("===========Saving Account================");
        savingAccount.displayAccountInfo();
        savingAccount.deposit(3000);
        savingAccount.withdraw(1000);
        savingAccount.calculateIntersetRate();
        System.out.println("================Current Account============");
        currentAccount.displayAccountInfo();
        currentAccount.withdraw(10000);
        currentAccount.displayOverDraftLimit();



    }
}
