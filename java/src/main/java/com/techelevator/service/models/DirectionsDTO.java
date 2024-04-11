package com.techelevator.service.models;

import java.util.List;

public class DirectionsDTO {

    private List<String[]> stepsStringList;

    public DirectionsDTO() {
    }

    public DirectionsDTO(List<String[]> stepsStringList) {
        this.stepsStringList = stepsStringList;
    }

    public List<String[]> getStepsStringList() {
        return stepsStringList;
    }

    public void setStepsStringList(List<String[]> stepsStringList) {
        this.stepsStringList = stepsStringList;
    }
}
