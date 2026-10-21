package org.example.gate;

import lombok.AllArgsConstructor;
import org.example.enums.VehicleType;
import org.example.factory.VehicleCreationFactory;
import org.example.model.ParkingSession;
import org.example.model.ParkingSpace;
import org.example.model.Vehicle;
import org.example.service.ParkingService;

@AllArgsConstructor
public class EntryGate {

    private final ParkingService parkingService;
    private final VehicleCreationFactory vehicleCreationFactory;

    public ParkingSession parkVehicle(String vehicleNo, VehicleType vehicleType)
    {
        Vehicle vehicle = vehicleCreationFactory.createVehicle(vehicleNo,vehicleType);
        return parkingService.park(vehicle);
    }
}
