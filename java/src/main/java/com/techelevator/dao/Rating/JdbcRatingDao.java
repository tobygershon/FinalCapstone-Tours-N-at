package com.techelevator.dao.Rating;

import com.techelevator.dao.Rating.Model.Rating;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcRatingDao implements RatingDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcRatingDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Rating> getRatingsByUserId(int id) {
        return null;
    }

    @Override
    public List<Rating> getRatingsByLandMarkId(int id) {
        return null;
    }
}
