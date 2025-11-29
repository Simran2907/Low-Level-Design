package com.example.parkinglot.dto;

import com.example.parkinglot.contants.VehicleType;

public class Car extends Vehicle{

    Car(int no){
        super(no,VehicleType.CAR);
    }
}
