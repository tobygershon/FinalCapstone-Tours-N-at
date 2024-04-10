package com.techelevator.controller;

import com.techelevator.dao.Rating.Model.Rating;
import com.techelevator.dao.Rating.RatingDao;
import com.techelevator.dao.User.UserDao;
import com.techelevator.dao.User.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping("/ratings/{userId}")
    public List<Rating> getRatingsByUserId(@PathVariable int userId, Principal principal) {
        User loggedInUser = userDao.getLoggedInUserByPrinciple(principal);
        int loggedInUserId = loggedInUser.getId();

        return ratingDao.getRatingsByUserId(loggedInUserId);
    }

    @GetMapping("/landmarks/{landmarkId}/ratings")
    public List<Rating> getRatingsByLandmarkId(@PathVariable int landmarkId) {
        return ratingDao.getRatingsByLandmarkId(landmarkId);
    }

    @PostMapping("/landmarks/{landmarkId}/ratings")
    public Rating createRating(@PathVariable int landmarkId, Rating rating) {
        return ratingDao.createRating(rating);
    }

    @PutMapping("/ratings/{ratingId}")
    public Rating updateRating(@PathVariable int ratingId, Rating rating) {
        return ratingDao.updateRating(rating);
    }

    @DeleteMapping("/ratings/{ratingId}")
    public void deleteRating(@PathVariable int ratingId) {
        int rowsAffected = ratingDao.deleteRating(ratingId);

        if (rowsAffected == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rating not found.");
        }
    }

}
