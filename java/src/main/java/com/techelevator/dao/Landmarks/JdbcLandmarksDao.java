package com.techelevator.dao.Landmarks;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcLandmarksDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcLandmarksDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
}
