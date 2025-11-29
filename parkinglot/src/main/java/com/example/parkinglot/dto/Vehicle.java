package com.example.parkinglot.dto;

import com.example.parkinglot.contants.VehicleType;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    private int vehicleNo;
    private VehicleType vehicleType;

}
