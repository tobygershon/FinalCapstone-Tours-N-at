package com.techelevator.service.models.places;

public class Summary {

    private Overview overview;

    public Summary() {
    }

    public Summary(Overview overview) {
        this.overview = overview;
    }

    public Overview getOverview() {
        return overview;
    }

    public void setOverview(Overview overview) {
        this.overview = overview;
    }
}
