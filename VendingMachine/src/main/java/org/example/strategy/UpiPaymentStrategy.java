package org.example.strategy;

import org.example.service.abstractions.PaymentStrategy;

public class UpiPaymentStrategy implements PaymentStrategy {

    @Override
    public void acceptPayment(double amount) {
        System.out.println("Upi Payment "+amount+" done");
    }

    @Override
    public void refund(double amount) {
        System.out.println(amount+" refunded");
    }

    @Override
    public void returnChange(double amount) {
        System.out.println(amount+" returned");
    }
}
