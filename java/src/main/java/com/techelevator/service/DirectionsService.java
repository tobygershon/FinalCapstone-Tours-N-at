package com.techelevator.service;

import com.techelevator.service.models.directions.Directions;
import org.springframework.web.client.RestTemplate;

public class DirectionsService {
// Don't forget to add API key to header?
    /*
    public ResponseEntity<String> callExternalApi(@RequestBody String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-api-key", "Hnmn1nhsg7wbkItsAdv");
        HttpEntity<Object> entity=new HttpEntity<Object>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return response;
    }
     */
    private static final String DIRECTIONS_API_BASE_URL = "https://maps.googleapis.com/maps/api/directions/json?";
//            using place_id's, url continues... origin=place_id:ChIJC4jFktX1NIgRenofIj7o45I&destination=place_id:ChIJjbGBQav2NIgRoARMOwbkqD4

    private static final String API_KEY = "AIzaSyBqJyZCzD-m22Izo98cXLx_PcND6cHoKWI";
    private final RestTemplate restTemplate = new RestTemplate();


    //methods

    public Directions getDirections(String originPlaceId, String destinationPlaceId) {
        String url = DIRECTIONS_API_BASE_URL + "origin=place_id:" + originPlaceId + "&destination=place_id:" + destinationPlaceId + "&key=" + API_KEY;

        return restTemplate.getForObject(url, Directions.class);
    }
}
