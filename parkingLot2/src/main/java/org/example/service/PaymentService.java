package org.example.service;

import org.example.enums.PaymentStatus;
import org.example.enums.PaymentType;
import org.example.model.Payment;

public class PaymentService {
    Payment makePayment(double amount, PaymentType paymentType){
        return new Payment(amount, PaymentStatus.SUCCESS,paymentType);
    }
}
