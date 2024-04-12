package com.techelevator.service;

import com.techelevator.dao.Landmarks.LandmarkDao;
import com.techelevator.exception.DaoException;
import com.techelevator.service.models.places.PlacesResponse;
import com.techelevator.service.models.places.Result;
import org.springframework.security.core.parameters.P;
import org.springframework.web.client.RestTemplate;

public class PlacesService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String BASE_API = "https://maps.googleapis.com/maps/api/place/details/json?place_id=";
    private final String API_KEY = "&key=AIzaSyBqJyZCzD-m22Izo98cXLx_PcND6cHoKWI";

    public PlacesService() {
    }



    public Result getPlaceInfoByPlaceId(String placeId) {
        PlacesResponse response = new PlacesResponse();
        String url = BASE_API + placeId + API_KEY;

        try {
            response = restTemplate.getForObject(url, PlacesResponse.class);
        } catch (Exception e) {
            throw new DaoException("Cannot connect to external places API");
        }

        return response.getResult();
    }

}
