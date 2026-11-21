package org.example.service;

import org.example.service.abstractions.PaymentStrategy;

public class RefundService {

    public void refund(double amount, PaymentStrategy paymentStrategy) {
        if (amount > 0) {
            paymentStrategy.refund(amount);
        }
    }
}