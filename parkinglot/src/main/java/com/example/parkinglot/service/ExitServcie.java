package com.example.parkinglot.service;


import com.example.parkinglot.dto.ParkingSpot;
import com.example.parkinglot.dto.ParkingSpotManager;
import com.example.parkinglot.dto.Ticket;
import com.example.parkinglot.dto.Vehicle;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@AllArgsConstructor
public class ExitServcie {

    private final ParkingSpotFactory parkingSpotFactory;

    public ParkingSpot exitVehicle(@RequestBody Ticket ticket){
        //calculate fare
        // free spot

        Vehicle vehicle = ticket.getVehicle();
        ParkingSpot parkingSpot = ticket.getParkingSpot();
        System.out.println(parkingSpot.isFree());
        ParkingSpotManager parkingSpotManager = parkingSpotFactory.getParkingSpotManager(vehicle.getVehicleType());
        parkingSpotManager.removeVehicle(parkingSpot);
        System.out.println(parkingSpot.isFree());
        return parkingSpot;
    }
}
