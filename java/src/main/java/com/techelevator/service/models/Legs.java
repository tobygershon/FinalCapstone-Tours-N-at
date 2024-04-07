package com.techelevator.service.models;

public class Legs {

    private Steps[] steps;

    public Legs(Steps[] steps) {
        this.steps = steps;
    }

    public Steps[] getSteps() {
        return steps;
    }

    public void setSteps(Steps[] steps) {
        this.steps = steps;
    }
}
