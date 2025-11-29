package com.example.parkinglot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Getter
@Service
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private LocalDateTime localDateTime;

    @Override
    public String toString() {
        return "Ticket{" +
                "vehicle=" + vehicle +
                ", parkingSpot=" + parkingSpot +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
