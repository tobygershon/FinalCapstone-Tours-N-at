package com.techelevator.service;

import com.techelevator.service.models.geocoder.GeocodeResults;
import org.springframework.web.client.RestTemplate;

public class GeocodingService {

    private final RestTemplate restTemplate = new RestTemplate();

    private final String BASE_URL = "https://maps.googleapis.com/maps/api/geocode/json?address=";
    private final String API_KEY = "&key=AIzaSyBqJyZCzD-m22Izo98cXLx_PcND6cHoKWI";


    public GeocodeResults getGeocodeInfo(String addressInput) {

        String[] addressArray = addressInput.split(" ");
        String urlInput = "";

        for (int i = 0; i < addressArray.length - 1; i++) {
            urlInput += (addressArray[i] + "+");
        }
        urlInput += addressArray[addressArray.length - 1];

        String url = BASE_URL + urlInput + API_KEY;

        return restTemplate.getForObject(url, GeocodeResults.class);
    }


}
