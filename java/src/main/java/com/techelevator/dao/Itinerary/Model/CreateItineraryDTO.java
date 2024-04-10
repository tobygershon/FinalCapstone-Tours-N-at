package com.techelevator.dao.Itinerary.Model;

import com.techelevator.dao.User.model.User;

import java.sql.Date;
import java.time.LocalDate;

public class CreateItineraryDTO {
    private int userId;
    private String itineraryName;
    private String startingLocation;
    private Date date;
//    tour_id as field also in create?  or add later?

    public CreateItineraryDTO(int userId, String itineraryName, String startingLocation, Date date) {
        this.userId = userId;
        this.itineraryName = itineraryName;
        this.startingLocation = startingLocation;
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

    public String getStartingLocation() {
        return startingLocation;
    }

    public void setStartingLocation(String startingLocation) {
        this.startingLocation = startingLocation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
