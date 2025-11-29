package com.example.parkinglot.controller;

import com.example.parkinglot.dto.ParkingSpot;
import com.example.parkinglot.dto.Ticket;
import com.example.parkinglot.service.ExitServcie;
import com.example.parkinglot.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class Exit {

    private final ExitServcie exitServcie;

    @PostMapping("/exitVehicle")
        public ParkingSpot exitVehicle(@RequestBody Ticket ticket){
        return exitServcie.exitVehicle(ticket);
    }
}
