package org.example.manager;

import org.example.enums.VehicleType;
import org.example.model.ParkingFloor;
import org.example.model.ParkingLot;
import org.example.model.ParkingSpace;
import org.example.model.Vehicle;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class TwoVehicleSpotManager extends ParkingLotManager{

    public  TwoVehicleSpotManager(ParkingLot parkingLot){
        super(parkingLot);
    }

    @Override
    public Optional<ParkingSpace> findAvailableSpace(Vehicle vehicle) {
        ParkingFloor parkingFloor = pparkingFloors.stream()
                .sorted(Comparator.comparingInt(ParkingFloor::getFloorNo))
                .filter(f -> !f.isFull())
                .filter(f -> f.getParkingSpaceList()
                        .stream()
                        .anyMatch(s -> s.canFit(VehicleType.BIKE))).findFirst().orElse(null);

        if(parkingFloor == null) return Optional.empty();
        floorNo = parkingFloor.getFloorNo();
        return parkingFloor.getParkingSpaceList().stream()
                .sorted(Comparator.comparingInt(ParkingSpace::getParkingNo))
                .filter(s -> s.canFit(VehicleType.BIKE)).findFirst();
    }
}
