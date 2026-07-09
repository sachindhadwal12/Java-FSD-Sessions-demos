package com.learning;

import java.util.InputMismatchException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        BankAccount bankAccount = new BankAccount(5000);
        try {
            bankAccount.withdraw(13000);
            //bank.update();
            //
        }
        catch (InputMismatchException | InsufficientBalanceException exception){
            System.out.println(exception.getMessage());
        }
    }
}
