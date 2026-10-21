package org.example.manager;

import org.example.enums.VehicleType;
import org.example.model.ParkingFloor;
import org.example.model.ParkingLot;
import org.example.model.ParkingSpace;
import org.example.model.Vehicle;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FourVehicleSpotManager extends ParkingLotManager{
    public FourVehicleSpotManager(ParkingLot parkingLot){
        super(parkingLot);
    }

    @Override
    public Optional<ParkingSpace> findAvailableSpace(Vehicle vehicle) {
        if(vehicle.getVehicleType() == VehicleType.TRUCK){
            return findSpace(vehicle.getVehicleType());
        }else{
            Optional<ParkingSpace> parkingSpace = findSpace(VehicleType.CAR);
            if(parkingSpace.isEmpty()) return findSpace(VehicleType.TRUCK);
            return parkingSpace;
        }


    }

    private Optional<ParkingSpace> findSpace(VehicleType vehicleType) {
        ParkingFloor parkingFloor = parkingLot.getParkingFloors().stream()
                .sorted(Comparator.comparingInt(ParkingFloor::getFloorNo))
                .filter(f -> !f.isFull())
                .filter(f -> f.getParkingSpaceList()
                        .stream()
                        .anyMatch(s -> s.canFit(vehicleType))).findFirst().orElse(null);

        if(parkingFloor == null) return Optional.empty();
        return parkingFloor.getParkingSpaceList().stream()
                .sorted(Comparator.comparingInt(ParkingSpace::getParkingNo))
                .filter(s -> s.canFit(vehicleType)).findFirst();
    }

}
