package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.example.enums.SessionStatus;

import java.time.LocalTime;

@AllArgsConstructor
@Data
@Builder
public class ParkingSession {

    private final LocalTime entryTime;
    private final int ticketId;
    private final Vehicle vehicle;
    private final ParkingSpace parkingSpace;
    private final int floorNo;

    private LocalTime exitTime;
    private SessionStatus status;
    private double amount;

    public void endSession(double amount){
        this.exitTime = LocalTime.now();
        this.amount = amount;
        this.status = SessionStatus.CLOSED;

    }

}
