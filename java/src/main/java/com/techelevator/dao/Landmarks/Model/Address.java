package com.techelevator.dao.Landmarks.Model;

public class Address {

    private int addressId;
    private int landmarkId;
    private int streetNumber;
    private String streetName;
    private String additionalAddressLine;
    private String city;
    private String state;
    private String zipCode;

    public Address(int addressId, int landmarkId, int streetNumber, String streetName, String additionalAddressLine, String city, String state, String zipCode) {
        this.addressId = addressId;
        this.landmarkId = landmarkId;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.additionalAddressLine = additionalAddressLine;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getLandmarkId() {
        return landmarkId;
    }

    public void setLandmarkId(int landmarkId) {
        this.landmarkId = landmarkId;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getAdditionalAddressLine() {
        return additionalAddressLine;
    }

    public void setAdditionalAddressLine(String additionalAddressLine) {
        this.additionalAddressLine = additionalAddressLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
