package com.techelevator.controller;

import com.techelevator.dao.Rating.Model.Rating;
import com.techelevator.dao.Rating.RatingDao;
import com.techelevator.dao.User.UserDao;
import com.techelevator.dao.User.model.User;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class RatingController {
    private final RatingDao ratingDao;
    private final UserDao userDao;

    public RatingController(RatingDao ratingDao, UserDao userDao) {
        this.ratingDao = ratingDao;
        this.userDao = userDao;
    }

    @GetMapping("/ratings")
    public List<Rating> getAllRatings() {
        return ratingDao.getAllRatings();
    }

    @GetMapping("/ratings/{userId}")
    public List<Rating> getRatingsByUserId(@PathVariable int userId, Principal principal) {
        User loggedInUser = userDao.getLoggedInUserByPrinciple(principal);
        int loggedInUserId = loggedInUser.getId();

        return ratingDao.getRatingsByUserId(loggedInUserId);
    }

    @GetMapping("/ratings/{landmarkId}")
    public List<Rating> getRatingsByLandmarkId(@PathVariable int landmarkId) {
        return ratingDao.getRatingsByLandmarkId(landmarkId);
    }

    @PostMapping("/ratings")
    public Rating createRating(Rating rating) {
        return ratingDao.createRating(rating);
    }

    @PutMapping("/ratings")
    public Rating updateRating(Rating rating) {
        return ratingDao.updateRating(rating);
    }

    @DeleteMapping("/ratings/{ratingId}")
    public void deleteRating(@PathVariable int ratingId) {
        return ratingDao.deleteRating(ratingId);
    }

}
