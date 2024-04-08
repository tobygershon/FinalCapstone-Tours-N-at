package com.techelevator.dao.Tour;

import com.techelevator.dao.Tour.Model.Route;
import com.techelevator.dao.Tour.Model.Tour;
import com.techelevator.dao.Tour.Model.UpdateTourDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcTourDao implements TourDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTourDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Tour getTourById(int id) {
        return null;
    }

    @Override
    public Tour updateTour(UpdateTourDTO tour) {
        return null;
    }

    @Override
    public Route getRouteById(int id) {
        return null;
    }

    @Override
    public int getDistanceOfRoute(int startingPointId, int endingPointId) {
        return 0;
    }
}
