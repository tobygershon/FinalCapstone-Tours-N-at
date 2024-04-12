package com.techelevator.dao.Itinerary.Model;

import java.time.LocalDate;

public class UpdateItineraryDTO {

    private int itineraryId;
    private int landmarkId;


    public UpdateItineraryDTO(int itineraryId, int landmarkId) {
        this.itineraryId = itineraryId;
        this.landmarkId = landmarkId;
    }

    public int getItineraryId() {
        return itineraryId;
    }

    public void setItineraryId(int itineraryId) {
        this.itineraryId = itineraryId;
    }

    public int getLandmarkId() {
        return landmarkId;
    }

    public void setLandmarkId(int landmarkId) {
        this.landmarkId = landmarkId;
    }
}
