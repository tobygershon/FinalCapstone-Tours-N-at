package com.techelevator.dao.Itinerary;

import com.techelevator.dao.Itinerary.Model.CreateItineraryDTO;
import com.techelevator.dao.Itinerary.Model.Itinerary;
import com.techelevator.dao.Itinerary.Model.UpdateItineraryDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcItineraryDao implements ItineraryDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcItineraryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Itinerary> getItinerariesByUserId(int userId) {
        return null;
    }

    @Override
    public Itinerary getItineraryById(int itineraryId) {
        return null;
    }

    @Override
    public Itinerary createItinerary(CreateItineraryDTO itinerary) {
        return null;
    }

    @Override
    public Itinerary updateItinerary(UpdateItineraryDTO itinerary) {
        return null;
    }

    @Override
    public boolean deleteItinerary(Itinerary itinerary) {
        return false;
    }
}
