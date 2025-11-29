package com.example.parkinglot.dto;

import com.example.parkinglot.contants.VehicleType;

public class Bike extends Vehicle{
    Bike(int no){
        super(no, VehicleType.BIKE);
    }
}
