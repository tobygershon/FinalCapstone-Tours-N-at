package com.techelevator.service.models.places;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {

    @JsonProperty("current_opening_hours")
    private CurrentHours currentHours;

    @JsonProperty("editorial_summary")
    private Summary summary;

    @JsonProperty("formatted_address")
    private String address;

    private String name;

    @JsonProperty("place_id")
    private String placeId;

    private double rating;

    @JsonProperty("types")
    private String[] designations;
    private String website;
    private String url;
    private Photos[] photos;

    public Result() {
    }

    public Result(CurrentHours currentHours, Summary summary, String address, String name, String placeId, double rating, String[] designations, String website, String url, Photos[] photos) {
        this.currentHours = currentHours;
        this.summary = summary;
        this.address = address;
        this.name = name;
        this.placeId = placeId;
        this.rating = rating;
        this.designations = designations;
        this.website = website;
        this.url = url;
        this.photos = photos;
    }

    public CurrentHours getCurrentHours() {
        return currentHours;
    }

    public void setCurrentHours(CurrentHours currentHours) {
        this.currentHours = currentHours;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String[] getDesignations() {
        return designations;
    }

    public void setDesignations(String[] designations) {
        this.designations = designations;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Photos[] getPhotos() {
        return photos;
    }

    public void setPhotos(Photos[] photos) {
        this.photos = photos;
    }
}
