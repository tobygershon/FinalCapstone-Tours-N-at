package com.techelevator.dao.Landmarks;

import com.techelevator.dao.Landmarks.Model.Landmark;
import com.techelevator.exception.DaoException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcLandmarkDao implements LandmarkDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcLandmarkDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Landmark getLandmarkById(int id) {
        Landmark landmark = new Landmark();
        String sql = "SELECT landmark_id, landmark_name, address, google_place_id FROM landmarks WHERE landmark_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if(results.next()) {
                landmark = mapRowToLandmark(results);
            }
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Could not connect to the database.");
        }
        return landmark;
    }

    @Override
    public String getPlaceIdByLandmarkId(int landmarkId) {
        String returnedPlaceId = "";
        String sql = "SELECT google_place_id FROM landmarks WHERE landmark_id = ?;";

        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, landmarkId);

            if (result.next()) {
                returnedPlaceId = result.getString("google_place_id");
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Could not connect to database");
        }

        return returnedPlaceId;
    }

    @Override
    public List<Landmark> getLandmarkByName(String landmarkName) {
        List<Landmark> landmarksList = new ArrayList<>();
        String sql = "SELECT landmark_id, landmark_name, address, google_place_id " +
                "FROM landmarks " +
                "WHERE landmark_name ILIKE ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + landmarkName + "%");
            while(results.next()) {
                Landmark resultLandmark = mapRowToLandmark(results);
                landmarksList.add(resultLandmark);
            }
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Could not connect to the database.");
        }
        return landmarksList;
    }

    @Override
    public List<Landmark> getAllLandmarks() {
        List<Landmark> landmarksList = new ArrayList<>();
        String sql = "SELECT landmark_id, landmark_name, address, google_place_id FROM landmarks;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while(results.next()) {
                Landmark resultLandmark = mapRowToLandmark(results);
                landmarksList.add(resultLandmark);
            }
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Could not connect to the database.");
        }
        return landmarksList;
    }

    @Override
    public List<Landmark> getLandmarksByDesignation(String landmarkDesignation) {
        List<Landmark> landmarksList = new ArrayList<>();
        String sql = "SELECT landmark_id, landmark_name, address, google_place_id FROM landmarks JOIN landmarks_designations USING (landmark_id) " +
                    "JOIN designations USING (designation_id) WHERE designation_name = ?;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, landmarkDesignation);
            while(results.next()) {
                Landmark resultLandmark = mapRowToLandmark(results);
                landmarksList.add(resultLandmark);
            }
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Could not connect to the database.");
        }
        return landmarksList;
    }
    @Override
    public int createLandmarkStartingPoint(String address, String placeId) {
        int returnedId = 0;
//        Change 'Other' desgination to 'starting point' designation?
        String sql = "INSERT INTO landmarks(landmark_name, address, google_place_id) VALUES ('Starting Point', ?, ?) returning landmark_id;";

        try {
            returnedId = jdbcTemplate.queryForObject(sql, int.class, address, placeId);

            if (returnedId == 0) {
                throw new DaoException("adding starting point didn't work");
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Could not connect to the database");
        }
        return returnedId;
    }



    //TODO: Add hours to method
    private Landmark mapRowToLandmark(SqlRowSet rowSet) {
        Landmark landmark = new Landmark();
        landmark.setLandmarkId(rowSet.getInt("landmark_id"));
        landmark.setLandmarkName(rowSet.getString("landmark_name"));
        landmark.setAddress(rowSet.getString("address"));
        landmark.setGooglePlaceId(rowSet.getString("google_place_id"));

        return landmark;
    }
}
