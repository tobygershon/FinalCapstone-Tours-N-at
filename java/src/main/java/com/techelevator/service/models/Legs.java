package com.techelevator.service.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Legs {

    private Steps[] steps;
    @JsonProperty("start_location")
    private StartLocation mapCenter;

    private Distance distance;

    public Legs() {
    }

    public Legs(Steps[] steps, StartLocation mapCenter, Distance distance) {
        this.steps = steps;
        this.mapCenter = mapCenter;
        this.distance = distance;
    }

    public Steps[] getSteps() {
        return steps;
    }

    public void setSteps(Steps[] steps) {
        this.steps = steps;
    }

    public StartLocation getMapCenter() {
        return mapCenter;
    }

    public void setMapCenter(StartLocation mapCenter) {
        this.mapCenter = mapCenter;
    }

    public Distance getDistance() {
        return distance;
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }
}
