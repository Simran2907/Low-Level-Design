package org.example.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParkingLot {

    private final List<ParkingFloor> parkingFloors;

    public ParkingLot(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = new ArrayList<>(parkingFloors);
    }

    public List<ParkingFloor> getParkingFloors() {
        return Collections.unmodifiableList(parkingFloors);
    }
}