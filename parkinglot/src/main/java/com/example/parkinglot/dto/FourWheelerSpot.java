package com.example.parkinglot.dto;

import com.example.parkinglot.contants.SpotType;

public class FourWheelerSpot extends ParkingSpot{
    public FourWheelerSpot(String id){
        super(id, SpotType.FOUR_WHEELER,30);
    }
}
