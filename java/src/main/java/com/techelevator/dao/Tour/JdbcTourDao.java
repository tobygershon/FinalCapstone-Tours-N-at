package com.techelevator.dao.Tour;

import com.techelevator.dao.Tour.Model.Route;
import com.techelevator.dao.Tour.Model.Tour;
import com.techelevator.dao.Tour.Model.UpdateTourDTO;
import com.techelevator.exception.DaoException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcTourDao implements TourDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTourDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Route getRouteById(int id) {
        String sql = "SELECT * from routes WHERE route_id = ?;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

            if (results.next()) {
                return mapRowToRoute(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to database", e);
        }
        return null;
    }

    @Override
    public Tour getTourById(int id) {

        String sql = "SELECT * from tours WHERE tour_id = ?;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

            if (results.next()) {
                return mapRowToTour(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Couldn't connect to database", e);
        }

        return null;
    }

    @Override
    public Tour updateTour(UpdateTourDTO dto) {
        String sql = "UPDATE tours SET route_1 = ?, route_2 = ?, route_3 = ?, " +
                     "route_4 = ?, route_5 = ?, route_6 = ? WHERE tour_id = ?;";

        try {
            int rowsUpdated = jdbcTemplate.update(sql, dto.getRoutes()[0].getRouteId(), dto.getRoutes()[1].getRouteId(),
                    dto.getRoutes()[2].getRouteId(), dto.getRoutes()[3].getRouteId(), dto.getRoutes()[4].getRouteId(),
                    dto.getRoutes()[5].getRouteId(), dto.getTourId());

            if (rowsUpdated == 0) {
                throw new DaoException("Expected 1 row to be updated but zero were updated");
            } else {
                return getTourById(dto.getTourId());
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Could not connect to database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation with update", e);
        }
    }

    @Override
    public int getDistanceOfRoute(int startingPointId, int endingPointId) {
        return 0;
    }

//    Map rows
    public Route mapRowToRoute(SqlRowSet results) {
        Route newRoute = new Route();
        newRoute.setRouteId(results.getInt("route_id"));
        newRoute.setStartingPointId(results.getInt("start_point"));
        newRoute.setEndingPointId(results.getInt("end_point"));
        newRoute.setPolyline(results.getString("polyline"));

        return newRoute;
    }

    public Tour mapRowToTour(SqlRowSet results) {
        Tour newTour = new Tour();
        Route route1 = getRouteById(results.getInt("route_1"));
        Route route2 = getRouteById(results.getInt("route_2"));
        Route route3 = getRouteById(results.getInt("route_3"));
        Route route4 = getRouteById(results.getInt("route_4"));
        Route route5 = getRouteById(results.getInt("route_5"));
        Route route6 = getRouteById(results.getInt("route_6"));
        Route[] routes = {route1, route2, route3, route4, route5, route6};

        newTour.setTourId(results.getInt("tour_id"));
        newTour.setRoutes(routes);

        return newTour;
    }
}
