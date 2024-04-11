package com.techelevator.service;

import org.springframework.web.client.RestTemplate;

public class PlacesService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String BASE_API = "https://maps.googleapis.com/maps/api/place/details/json?place_id=";
    private final String API_KEY = "&key=AIzaSyBqJyZCzD-m22Izo98cXLx_PcND6cHoKWI";

    public PlacesService() {
    }

    public

}
