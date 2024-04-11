package com.techelevator.dao.Landmarks.Model;

public class Designations {
    private String designation_name;
    private int designation_id;

    public Designations(String designation_name, int designation_id) {
        this.designation_name = designation_name;
        this.designation_id = designation_id;
    }

    public void setDesignation_name(String designation_name) {
        this.designation_name = designation_name;
    }

    public void setDesignation_id(int designation_id) {
        this.designation_id = designation_id;
    }

    public String getDesignation_name() {
        return designation_name;
    }

    public int getDesignation_id() {
        return designation_id;
    }
}
