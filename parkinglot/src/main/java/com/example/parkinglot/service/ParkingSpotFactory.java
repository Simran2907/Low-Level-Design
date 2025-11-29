package com.example.parkinglot.service;

import com.example.parkinglot.contants.VehicleType;
import com.example.parkinglot.dto.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ParkingSpotFactory {

    List<ParkingSpot> twoWheelerParkingSpotList;
    List<ParkingSpot> fourWheelerParkingSpotList;

   public ParkingSpotManager getParkingSpotManager(VehicleType vehicleType){
       return switch (vehicleType){
           case CAR -> new FourWheelerSpotManager(fourWheelerParkingSpotList);
           case BIKE -> new TwoWheelerSpotManager(twoWheelerParkingSpotList);
       };
   }

   public void initializeParkingspots(){
       twoWheelerParkingSpotList.addAll(List.of(new TwoWheelerSpot("1A"), new TwoWheelerSpot("1B"), new TwoWheelerSpot("1C")));
       fourWheelerParkingSpotList.addAll(List.of(new FourWheelerSpot("2A"), new FourWheelerSpot("2B"), new FourWheelerSpot("2C")));
   }
}
