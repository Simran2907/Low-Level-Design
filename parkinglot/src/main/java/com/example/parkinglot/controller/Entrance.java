package com.example.parkinglot.controller;


import com.example.parkinglot.dto.Ticket;
import com.example.parkinglot.dto.Vehicle;
import com.example.parkinglot.service.EntranceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class Entrance {

    private final EntranceService entranceService;

    @PostMapping("/entryVehicle")
    public Ticket enterVehicle(@RequestBody Vehicle vehicle){
        return entranceService.parkVehicle(vehicle);

    }
}
