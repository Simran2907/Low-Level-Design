package com.example.parkinglot.dto;

import com.example.parkinglot.contants.SpotType;
import lombok.Getter;
import lombok.Setter;


public abstract class ParkingSpot {
    private String parkingId;
    private Vehicle vehicle;
    private SpotType spotType;
    private boolean free =  true;
    private double price;

    ParkingSpot(String id, SpotType spotType,double price){
        this.parkingId = id;
        this.spotType = spotType;
        this.price = price;
    }

    public void park(Vehicle c){
        this.vehicle = c;
        this.free=false;
    }

    public void vacant(){
        this.vehicle = null;
        this.free = true;
    }

    public boolean isFree(){
        return this.free;
    }

    public String getID(){
        return this.parkingId;
    }

    public SpotType getSpotType(){
        return this.spotType;
    }

}
