package com.techelevator.controller;

import com.techelevator.dao.Rating.Model.Rating;
import com.techelevator.dao.Rating.RatingDao;
import com.techelevator.dao.User.UserDao;
import com.techelevator.dao.User.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Principal;
import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin
public class RatingController {
    private static final Logger log = LoggerFactory.getLogger(RatingController.class);
    private final RatingDao ratingDao;
    private final UserDao userDao;

    public RatingController(RatingDao ratingDao, UserDao userDao) {
        this.ratingDao = ratingDao;
        this.userDao = userDao;
    }

    @GetMapping("/ratings")
    public List<Rating> getRatingsByUser(Principal principal) {
        User loggedInUser = userDao.getLoggedInUserByPrinciple(principal);
        int userId = loggedInUser.getId();
        log.info("Fetching ratings for user ID: {}", userId);
        return ratingDao.getRatingsByUserId(userId);
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/landmarks/{landmarkId}/ratings")
    public List<Rating> getRatingsByLandmarkId(@PathVariable int landmarkId) {
        log.info("Fetching ratings for landmark ID: {}", landmarkId);
        return ratingDao.getRatingsByLandmarkId(landmarkId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/landmarks/{landmarkId}/ratings")
    @Transactional
    public Rating createRating(@PathVariable int landmarkId, @RequestBody Rating rating, Principal principal) {
        User user = userDao.getLoggedInUserByPrinciple(principal);
        int userId = user.getId();
        rating.setUserId(userId);
        rating.setLandmarkId(landmarkId);
        log.info("Creating rating for user ID: {} and landmark ID: {}", userId, landmarkId);
        return ratingDao.createRating(rating);
    }

    @PutMapping("/ratings/{ratingId}")
    @Transactional
    public void updateRating(@PathVariable int ratingId, @RequestBody Rating rating, Principal principal) {
        User loggedInUser = userDao.getLoggedInUserByPrinciple(principal);
        int loggedInUserId = loggedInUser.getId();
        if (rating.getUserId() != loggedInUserId) {
            log.error("Unauthorized attempt to update rating by user ID: {}", loggedInUserId);
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not authorized to update this rating.");
        }
        Rating existingRating = ratingDao.getRatingById(ratingId);
        if (existingRating == null) {
            log.error("Rating not found for ID: {}", ratingId);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rating not found.");
        }
        if (existingRating.getLandmarkId() != rating.getLandmarkId()) {
            log.error("Mismatched landmark ID on update for rating ID: {}", ratingId);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Mismatched landmark ID.");
        }
        rating.setUserId(loggedInUserId);
        rating.setRatingId(ratingId);
        log.info("Updating rating ID: {}", ratingId);
        ratingDao.updateRating(rating);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/ratings/{ratingId}")
    public void deleteRating(@PathVariable int ratingId, Principal principal) {
        User loggedInUser = userDao.getLoggedInUserByPrinciple(principal);
        int loggedInUserId = loggedInUser.getId();
        Rating rating = ratingDao.getRatingById(ratingId);
        if (rating.getUserId() != loggedInUserId) {
            log.error("Unauthorized attempt to delete rating by user ID: {}", loggedInUserId);
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You are not authorized to delete this rating.");
        }
        log.info("Deleting rating ID: {}", ratingId);
        ratingDao.deleteRating(ratingId);
    }
}
