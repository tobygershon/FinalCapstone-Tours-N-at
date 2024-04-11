package com.techelevator.dao.Rating.Model;


public class Rating {
    private int ratingId;
    private int userId;
    private int landmarkId;
    private boolean isGood;

    public Rating() {
    }

    public Rating(int ratingId, int userId, int landmarkId, boolean isGood) {
        this.ratingId = ratingId;
        this.userId = userId;
        this.landmarkId = landmarkId;
        this.isGood = isGood;
    }

    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLandmarkId() {
        return landmarkId;
    }

    public void setLandmarkId(int landmarkId) {
        this.landmarkId = landmarkId;
    }

    public boolean getIsGood() {
        return isGood;
    }

    public void setIsGood(boolean isGood) {
        this.isGood = isGood;
    }
}
