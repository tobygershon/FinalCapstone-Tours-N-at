package com.techelevator.service;

import com.techelevator.exception.DaoException;
import com.techelevator.service.models.geocoder.GeocodeResults;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class GeocodingService {

    private final RestTemplate restTemplate = new RestTemplate();

    private final String BASE_URL = "https://maps.googleapis.com/maps/api/geocode/json?address=";
    private final String API_KEY = "&key=" + GOOGLE_API_KEY;


    public GeocodeResults getGeocodeInfo(String addressInput) {

        String[] addressArray = addressInput.split(" ");
        String urlInput = "";
        GeocodeResults results = null;

        for (int i = 0; i < addressArray.length - 1; i++) {
            urlInput += (addressArray[i] + "+");
        }
        urlInput += addressArray[addressArray.length - 1];

        String url = BASE_URL + urlInput + "+ Pittsburgh" + API_KEY;
        try {
            results = restTemplate.getForObject(url, GeocodeResults.class);
        } catch (RestClientResponseException | ResourceAccessException e) {
            throw new DaoException("Service is unable to return a valid response");
        }
        return results;
    }


}
