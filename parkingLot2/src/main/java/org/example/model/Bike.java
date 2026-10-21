package org.example.model;

import org.example.enums.VehicleType;

public class Bike extends Vehicle{
    public Bike(String vehicleNo){
        super(vehicleNo, VehicleType.BIKE);
    }
}
