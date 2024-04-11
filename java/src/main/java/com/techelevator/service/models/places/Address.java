package com.techelevator.service.models.places;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {

    @JsonProperty("formatted_address")
    private String address;

    public Address() {
    }

    public Address(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
