package com.techelevator.service.models;

public class GeocodeDTO {

    private String address;

    public GeocodeDTO() {
    }

    public GeocodeDTO(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
