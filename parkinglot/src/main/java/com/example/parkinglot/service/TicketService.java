package com.example.parkinglot.service;

import com.example.parkinglot.dto.ParkingSpot;
import com.example.parkinglot.dto.ParkingSpotManager;
import com.example.parkinglot.dto.Ticket;
import com.example.parkinglot.dto.Vehicle;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TicketService {

    public Ticket generateTicket(Vehicle vehicle, ParkingSpot parkingSpot){
        return Ticket.builder().vehicle(vehicle).parkingSpot(parkingSpot).localDateTime(LocalDateTime.now()).build();
    }
}
