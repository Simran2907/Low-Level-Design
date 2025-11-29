package com.example.parkinglot.service;

import com.example.parkinglot.dto.ParkingSpot;
import com.example.parkinglot.dto.ParkingSpotManager;
import com.example.parkinglot.dto.Ticket;
import com.example.parkinglot.dto.Vehicle;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EntranceService {

    private final ParkingSpotFactory parkingSpotFactory;
    private final TicketService ticketService;
    public Ticket parkVehicle(Vehicle vehicle) {

        // vehcile came
        // find spot'

        ParkingSpotManager parkingSpotManager  = parkingSpotFactory.getParkingSpotManager(vehicle.getVehicleType());
        ParkingSpot parkingSpot = parkingSpotManager.findSpot();
        if(parkingSpot == null) throw new RuntimeException("No Parking Spot");

        parkingSpotManager.parkVehicle(vehicle,parkingSpot);
        Ticket ticket = ticketService.generateTicket(vehicle,parkingSpot);
        return ticket;


    }
}
