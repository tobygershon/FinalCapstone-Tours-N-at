package com.techelevator.service.models.places;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeekdayHours {

    @JsonProperty("weekday_text")
    private String[] hours;

    public WeekdayHours() {
    }

    public WeekdayHours(String[] hours) {
        this.hours = hours;
    }

    public String[] getHours() {
        return hours;
    }

    public void setHours(String[] hours) {
        this.hours = hours;
    }
}
