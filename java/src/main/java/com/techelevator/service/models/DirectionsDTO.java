package com.techelevator.service.models;

public class DirectionsDTO {

    private Legs[] legs;

    public DirectionsDTO() {
    }

    public DirectionsDTO(Legs[] legs) {
        this.legs = legs;
    }

    public Legs[] getLegs() {
        return legs;
    }

    public void setLegs(Legs[] legs) {
        this.legs = legs;
    }
}
