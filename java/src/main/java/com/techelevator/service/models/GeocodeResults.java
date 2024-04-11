package com.techelevator.service.models;

public class GeocodeResults {

    private Results[] results;

    public GeocodeResults() {
    }

    public GeocodeResults(Results[] results) {
        this.results = results;
    }

    public Results[] getResults() {
        return results;
    }

    public void setResults(Results[] results) {
        this.results = results;
    }
}
