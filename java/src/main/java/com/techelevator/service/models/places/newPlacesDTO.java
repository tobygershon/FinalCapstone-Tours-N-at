package com.techelevator.service.models.places;

import java.util.List;

public class newPlacesDTO {

    private List<String> urls;

    private List<String> destinations;

    public newPlacesDTO() {
    }

    public newPlacesDTO(List<String> urls, List<String> destinations) {
        this.urls = urls;
        this.destinations = destinations;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public List<String> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<String> destinations) {
        this.destinations = destinations;
    }
}
