package org.example.service.abstractions;

public interface PaymentStrategy {
    void acceptPayment(double amount);
    void refund(double amount);
    void returnChange(double amount);
}
