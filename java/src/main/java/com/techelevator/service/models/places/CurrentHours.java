package com.techelevator.service.models.places;

import com.techelevator.dao.Landmarks.Model.Hours;

public class CurrentHours {

    private Hours hours;

    public CurrentHours() {
    }

    public CurrentHours(Hours hours) {
        this.hours = hours;
    }

    public Hours getHours() {
        return hours;
    }

    public void setHours(Hours hours) {
        this.hours = hours;
    }
}
