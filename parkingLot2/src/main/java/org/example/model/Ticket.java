package org.example.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalTime;

@Builder
@Data
public class Ticket {
    private ParkingSpace parkingSpace;
    private ParkingFloor parkingFloor;
    private Vehicle vehicle;
    private LocalTime entryTime;
}
