package com.techelevator.dao.Itinerary.Model;

import java.time.LocalDate;

public class Itinerary {

    private int id;
    private int userId;
    private String itineraryName;
    private int startingLocationId;
    private LocalDate tourDate;
    private int tourId;

    public Itinerary(int id, int userId, String itineraryName, int startingLocationId, LocalDate tourDate, int tourId) {
        this.id = id;
        this.userId = userId;
        this.itineraryName = itineraryName;
        this.startingLocationId = startingLocationId;
        this.tourDate = tourDate;
        this.tourId = tourId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getItineraryName() {
        return itineraryName;
    }

    public void setItineraryName(String itineraryName) {
        this.itineraryName = itineraryName;
    }

    public int getStartingLocationId() {
        return startingLocationId;
    }

    public void setStartingLocationId(int startingLocationId) {
        this.startingLocationId = startingLocationId;
    }

    public LocalDate getTourDate() {
        return tourDate;
    }

    public void setTourDate(LocalDate tourDate) {
        this.tourDate = tourDate;
    }

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }
}
