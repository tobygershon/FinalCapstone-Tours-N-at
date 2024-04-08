package com.techelevator.dao.Rating;

import com.techelevator.dao.Rating.Model.Rating;

import java.util.List;

public interface RatingDao {

    List<Rating> getRatingsByUserId(int id);
    List<Rating> getRatingsByLandMarkId(int id);
}
