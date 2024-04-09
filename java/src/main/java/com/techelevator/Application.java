package com.techelevator;

import com.techelevator.dao.Landmarks.JdbcLandmarkDao;
import com.techelevator.dao.Landmarks.LandmarkDao;
import com.techelevator.dao.Landmarks.Model.Landmark;
import com.techelevator.service.DirectionsService;
import com.techelevator.service.models.Directions;
import com.techelevator.service.models.Legs;
import com.techelevator.service.models.Routes;
import com.techelevator.service.models.Steps;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        }
    }

