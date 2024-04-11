package com.techelevator.controller;

import com.techelevator.dao.Landmarks.LandmarkDao;
import com.techelevator.service.GeocodingService;
import com.techelevator.service.models.GeocodeDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class GeocodeController {

    private final GeocodingService geocodingService = new GeocodingService();
    private final LandmarkDao landmarkDao;

    public GeocodeController(LandmarkDao landmarkDao) {
        this.landmarkDao = landmarkDao;
    }

    @GetMapping("/geocode")
    public GeocodeDTO getInfoFromAddress(@RequestBody GeocodeDTO dto) {

        //TODO: add google_place_id to database as starting location

        GeocodeDTO responseDTO = new GeocodeDTO();

        String addressResponse = geocodingService.getGeocodeInfo(dto.getAddress()).getResults()[0].getAddress();
        responseDTO.setAddress(addressResponse);
        return responseDTO;
        }
    }

