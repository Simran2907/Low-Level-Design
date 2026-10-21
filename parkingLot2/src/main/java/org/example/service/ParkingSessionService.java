package org.example.service;


import org.example.enums.SessionStatus;
import org.example.model.ParkingSession;
import org.example.model.ParkingSpace;
import org.example.model.Vehicle;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ParkingSessionService {
    private final Map<String,ParkingSession> activeParkingSessions = new HashMap<>();
    private volatile AtomicInteger id = new AtomicInteger(0);

    public ParkingSession getActiveSession(Vehicle vehicle){
        return activeParkingSessions.get(vehicle.getVehicleNo());
    }

    public ParkingSession getParkingSession(Vehicle vehicle, ParkingSpace parkingSpace,int floorNo){

       ParkingSession parkingSession = ParkingSession.builder()
                .floorNo(floorNo)
                .parkingSpace(parkingSpace)
                .entryTime(LocalTime.now())
                .status(SessionStatus.ACTIVE)
                .vehicle(vehicle)
                .ticketId(id.incrementAndGet())
               .build();
       activeParkingSessions.put(vehicle.getVehicleNo(),parkingSession);
       return parkingSession;
    }

    public ParkingSession getParkingSessionByTicket(int ticketId) {
        return activeParkingSessions.values().stream().filter(v -> v.getTicketId() == ticketId).findFirst().orElse(null);
    }
}
