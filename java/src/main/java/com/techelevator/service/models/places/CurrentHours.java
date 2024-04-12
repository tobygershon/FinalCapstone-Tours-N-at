package com.techelevator.service.models.places;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techelevator.dao.Landmarks.Model.Hours;

public class CurrentHours {

    @JsonProperty("weekday_text")
    private String[] dayHours;

    public CurrentHours() {
    }

    public CurrentHours(String[] dayHours) {
        this.dayHours = dayHours;
    }

    public String[] getHours() {
        return dayHours;
    }

    public void setHours(String[] dayHours) {
        this.dayHours = dayHours;
    }
}
