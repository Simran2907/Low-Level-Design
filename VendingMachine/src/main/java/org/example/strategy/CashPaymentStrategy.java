package org.example.strategy;

import org.example.service.abstractions.PaymentStrategy;

public class CashPaymentStrategy implements PaymentStrategy {

    @Override
    public void acceptPayment(double amount) {
        System.out.println("Cash Amount received : "+amount);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Cash Refund amount : "+amount);
    }

    @Override
    public void returnChange(double amount) {
        System.out.println("Cash Amount returned : "+amount);
    }
}
