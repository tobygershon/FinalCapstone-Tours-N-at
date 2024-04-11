package com.techelevator.service.models.places;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {

    @JsonProperty("current_opening_hours")
    private CurrentHours currentHours;

    @JsonProperty("editorial_summary")
    private Summary summary;

    @JsonProperty("formatted_address")
    private Address address;

}
