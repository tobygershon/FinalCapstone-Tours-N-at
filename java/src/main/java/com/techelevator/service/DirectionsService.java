package com.techelevator.service;

import com.techelevator.service.models.Directions;
import org.springframework.web.client.RestTemplate;

public class DirectionsService {
// Don't forget to add API key to header?
    private static final String DIRECTIONS_API_BASE_URL = "https://maps.googleapis.com/maps/api/directions/json?";
//            using place_id's, url continues... origin=place_id:ChIJC4jFktX1NIgRenofIj7o45I&destination=place_id:ChIJjbGBQav2NIgRoARMOwbkqD4

    private final RestTemplate restTemplate = new RestTemplate();

    //methods

    public Directions getDirections(String originPlaceId, String destinationPlaceId) {
        String url = DIRECTIONS_API_BASE_URL + "origin=place_id:" + originPlaceId + "&destination=place_id:" + destinationPlaceId;

        return restTemplate.getForObject(url, Directions.class);
    }
}
