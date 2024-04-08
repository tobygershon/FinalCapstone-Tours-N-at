package com.techelevator.service.models;

import org.springframework.data.geo.Distance;

public class Legs {

    private Steps[] steps;
//    private Distance distance;

    public Legs() {
    }

//    public Legs(Steps[] steps, Distance distance) {
//        this.steps = steps;
////        this.distance = distance;
//    }

//    public Distance getDistance() {
////        return distance;
//    }

//    public void setDistance(Distance distance) {
//        this.distance = distance;
//    }

    public Steps[] getSteps() {
        return steps;
    }

    public void setSteps(Steps[] steps) {
        this.steps = steps;
    }
}
