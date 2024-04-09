package com.techelevator.dao.Itinerary.Model;

import org.apache.tomcat.jni.Local;

import java.time.LocalDate;

public class UpdateItineraryDTO {

    private int itineraryId;
    private String itineraryName;
    private int startingLocationId;
    private LocalDate tourDate;
    private int tourId;


    public UpdateItineraryDTO(int itineraryId, int startingLocationId, LocalDate tourDate) {
        this.itineraryId = itineraryId;
        this.startingLocationId = startingLocationId;
        this.tourDate = tourDate;
    }

    public int getItineraryId() {
        return itineraryId;
    }

    public void setItineraryId(int itineraryId) {
        this.itineraryId = itineraryId;
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
