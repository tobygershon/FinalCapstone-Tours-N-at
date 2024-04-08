package com.techelevator.dao.Itinerary.Model;

import com.techelevator.dao.User.model.User;

import java.time.LocalDate;

public class CreateItineraryDTO {

    private int userId;
    private String itineraryName;
    private int startingLocationId;
    private LocalDate date;
//    tour_id as field also in create?  or add later?

    public CreateItineraryDTO(int userId, String itineraryName, int startingLocationId, LocalDate date) {
        this.userId = userId;
        this.itineraryName = itineraryName;
        this.startingLocationId = startingLocationId;
        this.date = date;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
