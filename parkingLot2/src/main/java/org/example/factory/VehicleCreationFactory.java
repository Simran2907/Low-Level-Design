package org.example.factory;

import org.example.enums.VehicleType;
import org.example.model.Bike;
import org.example.model.Car;
import org.example.model.Truck;
import org.example.model.Vehicle;

public class VehicleCreationFactory {

    public Vehicle createVehicle(String vehicleNo, VehicleType vehicleType){
        return switch (vehicleType) {
            case CAR -> new Car(vehicleNo);
            case BIKE -> new Bike(vehicleNo);
            case TRUCK -> new Truck(vehicleNo);
        };
    }
}
