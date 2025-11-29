package com.example.parkinglot.dto;

import com.example.parkinglot.contants.SpotType;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public abstract class ParkingSpotManager {
    public List<ParkingSpot> parkingSpots;

    public ParkingSpotManager(List<ParkingSpot> parkingSpots){
        this.parkingSpots = parkingSpots;
    }

    public void addSpot(ParkingSpot parkingSpot){
        this.parkingSpots.add(parkingSpot);
    }

    public void removeSpot(ParkingSpot parkingSpot){
        this.parkingSpots.remove(parkingSpot);
    }

    public ParkingSpot findSpot(){
        for(ParkingSpot parkingSpot : parkingSpots){
            if(parkingSpot.isFree()) return parkingSpot;
        }
        return null;
    }

    public void parkVehicle(Vehicle vehicle,ParkingSpot parkingSpot){
        parkingSpot.park(vehicle);
    }

    public void removeVehicle(ParkingSpot parkingSpot){
        parkingSpot.vacant();
    }



}
