package org.example.strategy;

import org.example.model.ParkingSession;

import java.time.Duration;
import java.time.LocalTime;

public class HourlyPricingStrategy implements PricingStrategy{
    @Override
    public double calculateFee(ParkingSession session, LocalTime exitTime) {
        Long minutes = Duration.between(session.getEntryTime(), exitTime).toMinutes();
        long hours = Math.max(1,(minutes)/60);
        return hours*session.getParkingSpace().getFees();
    }
}
