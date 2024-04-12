package com.techelevator.service.models.geocoder;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Results {

    @JsonProperty("formatted_address")
    private String address;

    @JsonProperty("place_id")
    private String placeId;

    public Results() {
    }

    public Results(String address, String placeId) {
        this.address = address;
        this.placeId = placeId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }
}
