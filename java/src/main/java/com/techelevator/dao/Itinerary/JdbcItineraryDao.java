package com.techelevator.dao.Itinerary;

import com.techelevator.dao.Itinerary.Model.CreateItineraryDTO;
import com.techelevator.dao.Itinerary.Model.Itinerary;
import com.techelevator.dao.Itinerary.Model.UpdateItineraryDTO;
import com.techelevator.dao.Landmarks.Model.Landmark;
import com.techelevator.exception.DaoException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcItineraryDao implements ItineraryDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcItineraryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Itinerary> getItinerariesByUserId(int userId) {
        List<Itinerary> userItineraries = new ArrayList<>();
        String sql = "SELECT * FROM itineraries WHERE user_id = ? ORDER BY tour_date;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            while (results.next()) {
                userItineraries.add(mapRowToItinerary(results));
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return userItineraries;
    }

    @Override
    public Itinerary getItineraryById(int itineraryId) {
        Itinerary itinerary = null;
        String sql = "SELECT * FROM itineraries WHERE itinerary_id = ?;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, itineraryId);
            if (results.next()) {
                itinerary = mapRowToItinerary(results);
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return itinerary;
    }

    @Override
    public Itinerary createItinerary(CreateItineraryDTO newItinerary) {
        Itinerary itinerary = null;
        String sql = "insert into itineraries (user_id, itinerary_name, starting_location, tour_date) values ?, ?, ?, ?;";
        int userId = newItinerary.getUserId();
        String name = newItinerary.getItineraryName();
        int startingLocationId = newItinerary.getStartingLocationId();
        Date date = Date.valueOf(newItinerary.getDate());

        try {
            int newItineraryId = jdbcTemplate.queryForObject(sql, int.class, userId, name, startingLocationId, date);
            itinerary = getItineraryById(newItineraryId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return itinerary;
    }

    @Override
    public Itinerary updateItinerary(UpdateItineraryDTO itinerary) {
        return null;
    }

    @Override
    public boolean deleteItinerary(Itinerary itinerary) {
        return false;
    }

    private Itinerary mapRowToItinerary(SqlRowSet rowSet) {
        Itinerary itinerary = new Itinerary();
        itinerary.setId(rowSet.getInt("itinerary_id"));
        itinerary.setUserId(rowSet.getInt("user_id"));
        itinerary.setItineraryName(rowSet.getString("itinerary_name"));
        itinerary.setStartingLocationId(rowSet.getInt("starting_location"));

        Date tourDateTemp = rowSet.getDate("tour_date");
        LocalDate tourDate = null;
        if (tourDateTemp != null) {
            tourDate = tourDateTemp.toLocalDate();
        }

        itinerary.setTourDate(tourDate);

        return itinerary;
    }
}
