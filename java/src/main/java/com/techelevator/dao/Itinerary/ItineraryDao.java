package com.techelevator.dao.Itinerary;

import com.techelevator.dao.Itinerary.Model.CreateItineraryDTO;
import com.techelevator.dao.Itinerary.Model.Itinerary;
import com.techelevator.dao.Itinerary.Model.AddOrDeleteLandmarkDTO;

import java.security.Principal;
import java.util.List;

public interface ItineraryDao {

    List<Itinerary> getItinerariesByUserId(int userId);

    Itinerary getItineraryById(int itineraryId);

    int getTourIdFromItineraryId(int itineraryId);

    Itinerary createItinerary(CreateItineraryDTO itinerary, Principal principal, String placeId, String address);

    void addOrDeleteLandmark(AddOrDeleteLandmarkDTO itinerary);

    int deleteItinerary(int itineraryId);

    Itinerary updateItinerary(Itinerary itineraryToUpdate);

    List<String> retrieveItineraryStops(int itineraryId);


}