package com.learning.payments;

public class Details {

    static void main() {
        Payment payment;
        payment = new UpiPayment();
        payment.pay(5000);
        payment = new CardPayment();
        payment.pay(3000);
    }
}
