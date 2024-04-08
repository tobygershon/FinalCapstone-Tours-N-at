package com.techelevator.dao.Landmarks.Model;

public class Landmarks {

    private int landmarkId;
    private String landmarkName;
    private Address address;
    private Hours hours;
    private String landmarkDesignation;
    private String googlePlaceId;

    public Landmarks(int landmarkId, String landmarkName, Address address, Hours hours, String landmarkDesignation, String googlePlaceId) {
        this.landmarkId = landmarkId;
        this.landmarkName = landmarkName;
        this.address = address;
        this.hours = hours;
        this.landmarkDesignation = landmarkDesignation;
        this.googlePlaceId = googlePlaceId;
    }

    public int getLandmarkId() {
        return landmarkId;
    }

    public void setLandmarkId(int landmarkId) {
        this.landmarkId = landmarkId;
    }

    public String getLandmarkName() {
        return landmarkName;
    }

    public void setLandmarkName(String landmarkName) {
        this.landmarkName = landmarkName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Hours getHours() {
        return hours;
    }

    public void setHours(Hours hours) {
        this.hours = hours;
    }

    public String getLandmarkDesignation() {
        return landmarkDesignation;
    }

    public void setLandmarkDesignation(String landmarkDesignation) {
        this.landmarkDesignation = landmarkDesignation;
    }

    public String getGooglePlaceId() {
        return googlePlaceId;
    }

    public void setGooglePlaceId(String googlePlaceId) {
        this.googlePlaceId = googlePlaceId;
    }
}
