package com.techelevator.dao.Rating;

import com.techelevator.dao.Rating.Model.Rating;

import java.util.List;

public interface RatingDao {

    public List<Rating> getAllRatings();
    List<Rating> getRatingsByUserId(int id);
    List<Rating> getRatingsByLandmarkId(int id);
    Rating createRating(Rating rating);
    Rating updateRating(Rating rating);
    int deleteRating(int ratingId);
}
