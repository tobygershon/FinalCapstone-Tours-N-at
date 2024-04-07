BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, landmarks, addresses, hours_of_operation, routes, tours, itineraries, ratings, users_itineraries, itineraries_landmarks;

CREATE TABLE users (
	user_id SERIAL,
	username VARCHAR(50) NOT NULL UNIQUE,
	password_hash VARCHAR(200) NOT NULL,
	role VARCHAR(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE landmarks (
	landmark_id SERIAL PRIMARY KEY,
	landmark_name VARCHAR(100) NOT NULL UNIQUE,
	address_id INT NOT NULL,
	hours_id INT,
	landmark_designation VARCHAR(50) NOT NULL CHECK (landmark_designation IN ('Park', 'Restaurant', 'Hotel', 'Museum', 'Sporting Venue', 'Attraction', 'Historic Site', 'Church', 'Other')),
	google_place_id VARCHAR(50) UNIQUE
);

CREATE TABLE addresses (
	address_id SERIAL PRIMARY KEY,
	landmark_id INT NOT NULL REFERENCES landmarks(landmark_id),
	street_number INT NOT NULL,
	street_name VARCHAR(100) NOT NULL,
	additional_address_line VARCHAR(100),
	city VARCHAR(25) NOT NULL DEFAULT 'Pittsburgh',
	state VARCHAR(2) NOT NULL DEFAULT 'PA',
	zip_code VARCHAR(9) NOT NULL
);

CREATE TABLE hours_of_operation (
	hours_id SERIAL PRIMARY KEY,
	landmark_id INT NOT NULL REFERENCES landmarks(landmark_id),
	day_of_week INT, -- use 1 for Sunday, 2 for Monday, ... 7 for Saturday
	opening_time TIME,
	closing_time TIME
);

CREATE TABLE routes (
	route_id SERIAL PRIMARY KEY,
	start_point INT NOT NULL REFERENCES landmarks(landmark_id),
	end_point INT NOT NULL REFERENCES landmarks(landmark_id),
	polyline VARCHAR (50)
);

CREATE TABLE tours (
	tour_id SERIAL PRIMARY KEY,
	route_1 INT NOT NULL REFERENCES routes(route_id),
	route_2 INT NOT NULL REFERENCES routes(route_id),
	route_3 INT NOT NULL REFERENCES routes(route_id),
	route_4 INT NOT NULL REFERENCES routes(route_id),
	route_5 INT NOT NULL REFERENCES routes(route_id),
	route_6 INT NOT NULL REFERENCES routes(route_id)
);

CREATE TABLE itineraries (
	itinerary_id SERIAL PRIMARY KEY,
	user_id INT NOT NULL REFERENCES users(user_id),
	itinerary_name VARCHAR (100) NOT NULL,
	starting_location INT NOT NULL REFERENCES landmarks(landmark_id),
	tour_date DATE NOT NULL CHECK (tour_date >= CURRENT_DATE),
	tour_id INT REFERENCES tours(tour_id)
);

CREATE TABLE ratings (
	rating_id SERIAL PRIMARY KEY,
	user_id INT NOT NULL REFERENCES users(user_id),
	landmark_id INT NOT NULL REFERENCES landmarks(landmark_id),
	is_good BOOLEAN NOT NULL
);

CREATE TABLE users_itineraries (
	user_id INT NOT NULL REFERENCES users(user_id),
	itinerary_id INT NOT NULL REFERENCES itineraries(itinerary_id),
	CONSTRAINT PK_users_itineraries PRIMARY KEY(user_id, itinerary_id)
);

CREATE TABLE itineraries_landmarks (
	itinerary_id INT NOT NULL REFERENCES itineraries(itinerary_id),
	landmark_id INT NOT NULL REFERENCES landmarks(landmark_id),
	CONSTRAINT PK_itineraries_landmarks PRIMARY KEY(itinerary_id, landmark_id)
);

ALTER TABLE users_itineraries ADD CONSTRAINT FK_users_itineraries_itinerary FOREIGN KEY(itinerary_id) REFERENCES itineraries(itinerary_id);
ALTER TABLE users_itineraries ADD CONSTRAINT FK_users_itineraries_user FOREIGN KEY(user_id) REFERENCES users(user_id);

ALTER TABLE itineraries_landmarks ADD CONSTRAINT FK_itineraries_landmarks_itinerary FOREIGN KEY(itinerary_id) REFERENCES itineraries(itinerary_id);
ALTER TABLE itineraries_landmarks ADD CONSTRAINT FK_itineraries_landmarks_landmark FOREIGN KEY(landmark_id) REFERENCES landmarks(landmark_id);

ALTER TABLE landmarks ADD CONSTRAINT FK_landmarks_address FOREIGN KEY(address_id) REFERENCES addresses(address_id);
ALTER TABLE landmarks ADD CONSTRAINT FK_landmarks_hours FOREIGN KEY(hours_id) REFERENCES hours_of_operation(hours_id);


COMMIT TRANSACTION;
