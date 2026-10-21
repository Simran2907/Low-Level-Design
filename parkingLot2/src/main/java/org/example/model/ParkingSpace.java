package org.example.model;

import lombok.Builder;
import lombok.Data;
import org.example.enums.SpaceType;
import org.example.enums.VehicleType;

@Data
@Builder
public class ParkingSpace {
    private int parkingNo;
    private SpaceType parkingType;
    private double fees;
    private boolean isEmpty = true;

    public ParkingSpace(int parkingNo, SpaceType parkingType, double fees) {
        this.parkingNo = parkingNo;
        this.parkingType = parkingType;
        this.fees = fees;
    }

    public boolean canFit(VehicleType vehicleType){
        return isEmpty && validSpace(vehicleType);
    }

    private boolean validSpace(VehicleType vehicleType) {
        return switch (vehicleType){
            case BIKE -> this.parkingType == SpaceType.BIKE_SPACE;
            case CAR -> this.parkingType == SpaceType.CAR_SPACE;
            case TRUCK -> this.parkingType == SpaceType.TRUCK_SPACE;
        };
    }


    public void release(){
        this.isEmpty = true;
    }

    public boolean fill(){
        if(!isEmpty) return false;
        this.isEmpty = false;
        return true;

    }
}
