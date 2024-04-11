package com.techelevator.dao.Itinerary.Model;

import com.techelevator.dao.User.model.User;

import java.sql.Date;
import java.time.LocalDate;

public class CreateItineraryDTO {

    private String itineraryName;
    private String startingLocation;
    private LocalDate date;
//    tour_id as field also in create?  or add later?

    public CreateItineraryDTO(String itineraryName, String startingLocation, LocalDate date) {
        this.itineraryName = itineraryName;
        this.startingLocation = startingLocation;
        this.date = date;
    }

    public String getItineraryName() {
        return itineraryName;
    }

    public void setItineraryName(String itineraryName) {
        this.itineraryName = itineraryName;
    }

    public String getStartingLocation() {
        return startingLocation;
    }

    public void setStartingLocation(String startingLocation) {
        this.startingLocation = startingLocation;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
