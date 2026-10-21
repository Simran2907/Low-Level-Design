package org.example.manager;

import lombok.Getter;
import org.example.model.ParkingFloor;
import org.example.model.ParkingLot;
import org.example.model.ParkingSpace;
import org.example.model.Vehicle;

import java.util.List;
import java.util.Optional;

public abstract class ParkingLotManager {
    public final ParkingLot parkingLot;
    @Getter
    public int floorNo;

    public ParkingLotManager(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }

    public abstract Optional<ParkingSpace> findAvailableSpace(Vehicle vehicle);
    boolean parkVehicle(Vehicle vehicle,ParkingSpace spot){
        return spot.fill();
    }
    void release(ParkingSpace space){
        space.release();
    }

}
