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

        Application testApplication = new Application();
        testApplication.run();
    }

    public void run() {
        DirectionsService directionsService = new DirectionsService();

        Directions directions = directionsService.getDirections("ChIJMZPC9wfuNIgRtg_N_7urk1o", "ChIJG7npSPTtNIgRiSMbNqoVL_k");

        for (Routes route : directions.getRoutes()) {
            for (Legs leg: route.getLegs()) {
                for (Steps step : leg.getSteps()) {
                    System.out.println(step.getHtmlStep());
                }
            };

        }
    }
}
