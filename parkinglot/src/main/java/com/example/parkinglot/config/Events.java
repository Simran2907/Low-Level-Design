package com.example.parkinglot.config;

import com.example.parkinglot.service.ParkingSpotFactory;
import lombok.AllArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Events {

    private final ParkingSpotFactory parkingSpotFactory;
    @EventListener(ApplicationReadyEvent.class)
    public void init(){
        parkingSpotFactory.initializeParkingspots();
    }
}
