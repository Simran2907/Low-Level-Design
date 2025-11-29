package com.example.parkinglot.dto;

import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class FourWheelerSpotManager extends ParkingSpotManager{

    public FourWheelerSpotManager(List<ParkingSpot> parkingSpots){
        super(parkingSpots);
    }
}
