package org.example.service;

import lombok.AllArgsConstructor;
import org.example.enums.PaymentStatus;
import org.example.enums.PaymentType;
import org.example.manager.FourVehicleSpotManager;
import org.example.manager.ParkingLotManager;
import org.example.manager.TwoVehicleSpotManager;
import org.example.model.*;
import org.example.strategy.FlatFeeStrategy;
import org.example.strategy.HourlyPricingStrategy;
import org.example.strategy.PricingStrategy;

import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class ParkingService {

    private final ParkingLotManager parkingLotManager;
    private final ParkingSessionService parkingSessionService;
    private final PaymentService paymentService;
    private final ParkingLot parkingLot;

    public ParkingSession park(Vehicle vehicle) {
        //check active session
       if(parkingSessionService.getActiveSession(vehicle) != null) return null;
       ParkingLotManager parkingLotManager = switch (vehicle.getVehicleType()){
           case CAR,TRUCK -> new FourVehicleSpotManager(parkingLot);
           case BIKE -> new TwoVehicleSpotManager(parkingLot);
       };
       Optional<ParkingSpace> parkingSpaceOptional = parkingLotManager.findAvailableSpace(vehicle);
       if (parkingSpaceOptional.isEmpty()) return null;
       ParkingSpace parkingSpace = parkingSpaceOptional.get();
       return parkingSpace.fill() ?
                parkingSessionService.getParkingSession(vehicle,parkingSpace, this.parkingLotManager.getFloorNo())
                    : null;

    }

    public Payment exit(int ticketId, PaymentType paymentType){
        ParkingSession parkingSession = parkingSessionService.getParkingSessionByTicket(ticketId);
        PricingStrategy pricingStrategy = Duration.between(parkingSession.getEntryTime(), LocalTime.now()).toHours()<1?
                new FlatFeeStrategy():new HourlyPricingStrategy();
        double amount = pricingStrategy.calculateFee(parkingSession,LocalTime.now());
        Payment payment = paymentService.makePayment(amount,paymentType);
        if(payment.getStatus() != PaymentStatus.SUCCESS) return null;
        parkingSession.endSession(amount);
        return payment;
    }

}
