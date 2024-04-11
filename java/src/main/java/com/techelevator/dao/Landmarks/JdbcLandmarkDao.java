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
    public List<String> getDesignationsForLandmark(int landmarkId) {
        List<String> designations = new ArrayList<>();
        String sql = "SELECT designation_name FROM designations " +
                "JOIN landmarks_designations USING (designation_id) " +
                "WHERE landmark_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, landmarkId);
        while (results.next()) {
            designations.add(results.getString("designation_name"));
        }
        return designations;
    }

    @Override
    public List<String> getAllDesignations() {
        List<String> designations = new ArrayList<>();
        String sql = "SELECT DISTINCT designation_name FROM designations;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            designations.add(results.getString("designation_name"));
        }
        return designations;
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
