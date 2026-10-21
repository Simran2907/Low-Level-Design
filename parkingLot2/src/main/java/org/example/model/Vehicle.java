package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.example.enums.VehicleType;

@Builder
@Data
@AllArgsConstructor
public abstract class Vehicle {
    private final String vehicleNo;
    private final VehicleType vehicleType;
}
