package org.example.gate;

import lombok.AllArgsConstructor;
import org.example.enums.PaymentType;
import org.example.model.Payment;
import org.example.model.Vehicle;
import org.example.service.ParkingService;

@AllArgsConstructor
public class ExitGate {

    private final ParkingService parkingService;

    public Payment exitVehicle(int ticketId, PaymentType paymentType){
        return parkingService.exit(ticketId,paymentType);
    }
}
