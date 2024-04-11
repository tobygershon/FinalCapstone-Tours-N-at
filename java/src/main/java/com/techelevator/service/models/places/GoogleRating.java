package com.techelevator.service.models.places;

public class GoogleRating {

    private String rating;

    public GoogleRating() {
    }

    public GoogleRating(String rating) {
        this.rating = rating;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
