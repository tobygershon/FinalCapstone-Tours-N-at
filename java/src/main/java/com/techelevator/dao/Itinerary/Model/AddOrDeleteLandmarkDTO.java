package com.techelevator.dao.Itinerary.Model;

public class AddOrDeleteLandmarkDTO {

    private int itineraryId;
    private int landmarkId;


    public AddOrDeleteLandmarkDTO(int itineraryId, int landmarkId) {
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
