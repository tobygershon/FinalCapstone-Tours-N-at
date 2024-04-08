package com.techelevator.dao.Itinerary.Model;

import org.apache.tomcat.jni.Local;

import java.time.LocalDate;

public class UpdateItineraryDTO {

    private int itineraryId;
    private int startingLocationId;
    private LocalDate tourDate;

//    need tourId or itinerary name as fields to update?


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
}
