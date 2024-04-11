package com.techelevator.service.models.places;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlaceId {

    @JsonProperty("place_id")
    private String googlePlaceId;

    public PlaceId() {
    }

    public PlaceId(String place_id) {
        this.googlePlaceId = place_id;
    }

    public String getPlace_id() {
        return googlePlaceId;
    }

    public void setPlace_id(String place_id) {
        this.googlePlaceId = place_id;
    }
}
