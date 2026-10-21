package org.example.model;

import org.example.enums.VehicleType;

public class Truck extends Vehicle{
    public Truck(String vehicleNo){
        super(vehicleNo, VehicleType.TRUCK);
    }
}
