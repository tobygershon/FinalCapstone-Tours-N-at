package com.techelevator.dao.Itinerary.Model;

import com.techelevator.dao.Landmarks.Model.Landmark;

import java.time.LocalDate;
import java.util.List;

public class Itinerary {
    private int itineraryId;
    private int userId;
    private String itineraryName;
    private int startingLocationId;
    private String startingLocationName;
    private LocalDate tourDate;
    private List<Landmark> listOfStops;


    public Itinerary() {

    }

    public Itinerary(int itineraryId, int userId, String itineraryName, int startingLocationId, String startingLocationName, LocalDate tourDate, int tourId, List<Landmark> listOfStops) {
        this.itineraryId = itineraryId;
        this.userId = userId;
        this.itineraryName = itineraryName;
        this.startingLocationId = startingLocationId;
        this.startingLocationName = startingLocationName;
        this.tourDate = tourDate;
        this.listOfStops = listOfStops;
    }

    public int getItineraryId() {
        return itineraryId;
    }

    public void setItineraryId(int itineraryId) {
        this.itineraryId = itineraryId;
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

    public String getStartingLocationName() {
        return startingLocationName;
    }

    public void setStartingLocationName(String startingLocationName) {
        this.startingLocationName = startingLocationName;
    }

    public LocalDate getTourDate() {
        return tourDate;
    }

    public void setTourDate(LocalDate tourDate) {
        this.tourDate = tourDate;
    }

    public List<Landmark> getListOfStops() {
        return listOfStops;
    }

    public void setListOfStops(List<Landmark> listOfStops) {
        this.listOfStops = listOfStops;
    }
}
