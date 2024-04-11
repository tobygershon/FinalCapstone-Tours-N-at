package com.techelevator.dao.Itinerary;

import com.techelevator.dao.Itinerary.Model.CreateItineraryDTO;
import com.techelevator.dao.Itinerary.Model.Itinerary;
import com.techelevator.dao.Itinerary.Model.UpdateItineraryDTO;

import java.util.List;

public interface ItineraryDao {

    List<Itinerary> getItinerariesByUserId(int userId);

    Itinerary getItineraryById(int itineraryId);

    int getTourIdFromItineraryId(int itineraryId);

    Itinerary createItinerary(CreateItineraryDTO itinerary, int userId);

    Itinerary updateItinerary(UpdateItineraryDTO itinerary);

    int deleteItinerary(int itineraryId);
}
