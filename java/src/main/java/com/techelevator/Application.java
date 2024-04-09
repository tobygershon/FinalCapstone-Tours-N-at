package com.techelevator;

import com.techelevator.service.DirectionsService;
import com.techelevator.service.models.Directions;
import com.techelevator.service.models.Legs;
import com.techelevator.service.models.Routes;
import com.techelevator.service.models.Steps;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
