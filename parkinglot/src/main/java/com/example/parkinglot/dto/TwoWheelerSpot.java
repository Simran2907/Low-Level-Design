package com.example.parkinglot.dto;

import com.example.parkinglot.contants.SpotType;

public class TwoWheelerSpot extends ParkingSpot{

    public TwoWheelerSpot(String id){
        super(id, SpotType.TWO_WHEELER,20);
    }

}
