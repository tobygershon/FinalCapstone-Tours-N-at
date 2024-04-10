insert into routes(route_id, start_point, end_point, polyline) values(1, 1, 2, 'test');
insert into routes(route_id, start_point, end_point, polyline) values(2, 2, 3, 'test2');
insert into tours(tour_id, route_1, route_2) values(1, 1, 2);
insert into itineraries(itinerary_id, user_id, itinerary_name, starting_location, tour_date, tour_id) values (1, 1, 'test', 1, '01/01/2025', 1);