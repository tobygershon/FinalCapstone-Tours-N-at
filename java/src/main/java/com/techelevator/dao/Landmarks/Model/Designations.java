package com.techelevator.dao.Landmarks.Model;

public class Designations {
    private String designationName;
    private int designationId;


    public Designations(String designationName, int designationId) {
        this.designationName = designationName;
        this.designationId = designationId;
    }

    public Designations() {

    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    public void setDesignationId(int designationId) {
        this.designationId = designationId;
    }

    public String getDesignationName() {
        return designationName;
    }

    public int getDesignationId() {
        return designationId;
    }
}
