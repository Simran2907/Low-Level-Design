package org.example.strategy;

import org.example.model.ParkingSession;

import java.time.LocalTime;

public interface PricingStrategy {
    double calculateFee(ParkingSession session, LocalTime exitTime);
}
