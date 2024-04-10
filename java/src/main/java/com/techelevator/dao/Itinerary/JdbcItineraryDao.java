package com.techelevator.dao.Itinerary;

import com.techelevator.dao.Itinerary.Model.CreateItineraryDTO;
import com.techelevator.dao.Itinerary.Model.Itinerary;
import com.techelevator.dao.Itinerary.Model.UpdateItineraryDTO;
import com.techelevator.dao.User.UserDao;
import com.techelevator.exception.DaoException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.net.http.HttpResponse;
import java.security.Principal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcItineraryDao implements ItineraryDao {
    private final JdbcTemplate jdbcTemplate;
    private final UserDao userDao;

    public JdbcItineraryDao(JdbcTemplate jdbcTemplate, UserDao userDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.userDao = userDao;
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
    public int getTourIdFromItineraryId(int itineraryId) {
        int tourId = 0;
        String sql = "SELECT tour_id FROM itineraries WHERE itinerary_id = ?;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, itineraryId);
            if (results.next()) {
                tourId = results.getInt("tour_id");
            }
            if (tourId == 0) {
                throw new DaoException("Unable to retrieve tour Id");
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return tourId;
    }

    @Override
    public Itinerary createItinerary(CreateItineraryDTO itineraryDTO, Principal principal) {
        Itinerary newItinerary = null;
        String sqlGet = "SELECT landmark_id FROM landmarks WHERE landmark_name = ?;";
        String sql = "INSERT INTO itineraries (user_id, itinerary_name, starting_location, tour_date) VALUES (?, ?, ?, ?);";
        int principalId = userDao.getLoggedInUserByPrinciple(principal).getId();
        int userId = itineraryDTO.getUserId();
        String name = itineraryDTO.getItineraryName();
        String startingLocation = itineraryDTO.getStartingLocation();
        Date date = itineraryDTO.getDate();
        if (principalId != userId) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        try {
            int startingLocationId = jdbcTemplate.queryForObject(sqlGet, int.class, startingLocation);
            int newItineraryId = jdbcTemplate.queryForObject(sql, int.class, userId, name, startingLocationId, date);
            newItinerary = getItineraryById(newItineraryId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return newItinerary;
    }

    @Override
    public Itinerary updateItinerary(UpdateItineraryDTO itineraryDTO) {
        Itinerary updatedItinerary = null;
        String sql = "UPDATE itineraries " +
                "SET itinerary_name = ?, starting_location = ?, tour_date = ?, tour_id = ? " +
                "WHERE itinerary_id = ?;";
        int startingLocationId = itineraryDTO.getStartingLocationId();
        String name = itineraryDTO.getItineraryName();
        Date tourDate = Date.valueOf(itineraryDTO.getTourDate());
        int tourId = itineraryDTO.getTourId();
        int itineraryId = itineraryDTO.getItineraryId();

        try {
            int numOfRows = jdbcTemplate.update(sql, name, startingLocationId, tourDate, tourId, itineraryId);

            if (numOfRows == 0) {
                throw new DaoException("Zero rows affected, expected at least one");
            } else {
                updatedItinerary = getItineraryById(itineraryId);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return updatedItinerary;
    }

    @Override
    public int deleteItinerary(int itineraryId) {
        int numOfRows = 0;
        String sql = "DELETE FROM itineraries WHERE itinerary_id = ?;";

        try {
            numOfRows = jdbcTemplate.update(sql, itineraryId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return numOfRows;
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
