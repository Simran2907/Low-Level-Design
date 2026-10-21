package org.example.model;

import lombok.Builder;
import lombok.Data;
import org.example.enums.VehicleType;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Data
@Builder
public class ParkingFloor {
    // contains a list of space
    // we can find nearest space to gate
    // check if floor is full or not

    private List<ParkingSpace> parkingSpaceList;
    private int floorNo;


    public Optional<ParkingSpace> findSpace(VehicleType vehicleType){
        return parkingSpaceList.stream().sorted(Comparator.comparing(ParkingSpace::getParkingNo))
                .filter(parkingSpace -> parkingSpace.canFit(vehicleType)).findFirst();
    }


    public boolean isFull(){
        return parkingSpaceList.stream().noneMatch(ParkingSpace::isEmpty);
    }
}
