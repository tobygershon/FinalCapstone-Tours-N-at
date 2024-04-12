package com.techelevator.service.models.places;

public class PlacesResponse {

    private Result result;

    public PlacesResponse() {

    }

    public PlacesResponse(Result result) {
        this.result = result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return this.result;
    }


}
