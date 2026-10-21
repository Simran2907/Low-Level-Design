package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.enums.PaymentStatus;
import org.example.enums.PaymentType;

@Data
@AllArgsConstructor
public class Payment {
    private final double amount;
    private PaymentStatus status;
    private PaymentType type;
}
