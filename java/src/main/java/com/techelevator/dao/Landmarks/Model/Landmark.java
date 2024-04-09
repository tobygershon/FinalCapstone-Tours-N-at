package com.techelevator.dao.Landmarks.Model;

public class Landmark {

    private int landmarkId;
    private String landmarkName;
    private String address;
    private Hours hours;
    private String googlePlaceId;

    public Landmark() {

    }

    public Landmark(int landmarkId, String landmarkName, String address, Hours hours, String googlePlaceId) {
        this.landmarkId = landmarkId;
        this.landmarkName = landmarkName;
        this.address = address;
        this.hours = hours;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Hours getHours() {
        return hours;
    }

    public void setHours(Hours hours) {
        this.hours = hours;
    }

    public String getGooglePlaceId() {
        return googlePlaceId;
    }

    public void setGooglePlaceId(String googlePlaceId) {
        this.googlePlaceId = googlePlaceId;
    }
}
