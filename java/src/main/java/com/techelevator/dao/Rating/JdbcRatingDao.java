package com.techelevator.dao.Rating;

import com.techelevator.dao.Rating.Model.Rating;
import com.techelevator.exception.DaoException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class JdbcRatingDao implements RatingDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcRatingDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Rating> getAllRatings() {
        List<Rating> ratings = new ArrayList<>();
        String sql = "SELECT rating_id, user_id, landmark_id, is_good FROM ratings;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                ratings.add(mapRowToRating(results));
            }
        } catch (Exception e) {
            throw new DaoException("Unable to retrieve all ratings", e);
        }
        return ratings;
    }

    @Override
    public List<Rating> getRatingsByUserId(int userId) {
        List<Rating> ratings = new ArrayList<>();
        String sql = "SELECT rating_id, user_id, ratings.landmark_id, is_good, landmark_name FROM ratings JOIN landmarks USING (landmark_id) WHERE user_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            while (results.next()) {
                ratings.add(mapRowToRating(results));
            }
        } catch (Exception e) {
            throw new DaoException("Unable to retrieve ratings by user ID", e);
        }
        return ratings;
    }

    @Override
    public List<Rating> getRatingsByLandmarkId(int landmarkId) {
        List<Rating> ratings = new ArrayList<>();
        String sql = "SELECT rating_id, user_id, landmark_id, is_good FROM ratings WHERE landmark_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, landmarkId);
            while (results.next()) {
                ratings.add(mapRowToRating(results));
            }
        } catch (Exception e) {
            throw new DaoException("Unable to retrieve ratings by landmark ID", e);
        }
        return ratings;
    }

    @Override
    public Rating getRatingById(int ratingId) {
        Rating rating = null;
        String sql = "SELECT ratings.rating_id, ratings.user_id, ratings.landmark_id, ratings.is_good, landmarks.landmark_name FROM ratings JOIN landmarks ON ratings.landmark_id = landmarks.landmark_id WHERE ratings.rating_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, ratingId);
            if (results.next()) {
                rating = mapRowToRating(results);
            }
        } catch (Exception e) {
            throw new DaoException("Unable to retrieve rating by rating id.", e);
        }
        return rating;
    }
    @Override
    public Rating createRating(Rating rating) {
        String sql = "INSERT INTO ratings (user_id, landmark_id, is_good) VALUES (?, ?, ?) RETURNING rating_id";
        try {
            Integer generatedId = jdbcTemplate.queryForObject(sql, Integer.class, rating.getUserId(), rating.getLandmarkId(), rating.getIsGood());
            if (generatedId != null) {
                rating.setRatingId(generatedId);
                return rating;
            } else {
                throw new DaoException("Failed to create rating, no ID obtained.");
            }
        } catch (Exception e) {
            throw new DaoException("Unable to create rating", e);
        }
    }

    @Override
    public void updateRating(Rating rating) {
        String sql = "UPDATE ratings SET is_good = ? WHERE user_id = ? AND landmark_id = ?";
        try {
            int rowsAffected = jdbcTemplate.update(sql, rating.getIsGood(), rating.getUserId(), rating.getLandmarkId());

            if (rowsAffected == 0) {
                throw new DaoException("Update operation failed or no record was found to update.");
            }
        } catch (Exception e) {
            throw new DaoException("Unable to update rating", e);
        }
    }

    @Override
    public void deleteRating(int ratingId) {
        String sql = "DELETE FROM ratings WHERE rating_id = ?";

        try {
            int rowsAffected = jdbcTemplate.update(sql, ratingId);
            if (rowsAffected == 0) {
                throw new DaoException("Delete operation failed or no record was found to delete.");
            }
        } catch (Exception e) {
            throw new DaoException("Unable to delete rating", e);
        }
    }

    @Override
    public Rating findRatingByUserAndLandmark(int userId, int landmarkId) {
        String sql = "SELECT * FROM ratings WHERE user_id = ? AND landmark_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId, landmarkId);
        if (results.next()) {
            return mapRowToRating(results);
        }
        return null;
    }


    private Rating mapRowToRating(SqlRowSet rowSet) {
        Rating rating = new Rating();
        rating.setRatingId(rowSet.getInt("rating_id"));
        rating.setUserId(rowSet.getInt("user_id"));
        rating.setLandmarkId(rowSet.getInt("landmark_id"));
        rating.setIsGood(rowSet.getBoolean("is_good"));

        try {
            String landmarkName = rowSet.getString("landmark_name");
            if (landmarkName != null) {
                rating.setLandmarkName(landmarkName);
            } else {
                rating.setLandmarkName("");
            }
        } catch (Exception e) {
            rating.setLandmarkName("");
        }

        return rating;
    }
}