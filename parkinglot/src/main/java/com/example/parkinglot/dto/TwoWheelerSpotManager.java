package com.example.parkinglot.dto;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class TwoWheelerSpotManager extends ParkingSpotManager{

    public TwoWheelerSpotManager(List<ParkingSpot> parkingSpots){
        super(parkingSpots);
    }
}
