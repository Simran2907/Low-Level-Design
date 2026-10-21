package org.example.strategy;

import org.example.model.ParkingSession;

import java.time.LocalTime;

public class FlatFeeStrategy implements PricingStrategy{
    @Override
    public double calculateFee(ParkingSession session, LocalTime exitTime) {
        return session.getAmount();
    }
}
