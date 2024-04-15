BEGIN TRANSACTION;

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
	address VARCHAR(200) NOT NULL,
	google_place_id VARCHAR(200) UNIQUE
);

CREATE TABLE designations (
    designation_id SERIAL PRIMARY KEY,
    designation_name VARCHAR(50) NOT NULL CHECK (designation_name IN ('Park', 'Food', 'Hotel', 'Museum', 'Scenic Viewpoint', 'Kid-Friendly', 'Sporting Venue', 'Attraction', 'Historic Site', 'Church', 'Starting Point', 'Other'))
);

--CREATE TABLE hours_of_operation (
--	hours_id SERIAL PRIMARY KEY,
--	landmark_id INT NOT NULL REFERENCES landmarks(landmark_id),
--	day_of_week INT, -- use 1 for Sunday, 2 for Monday, ... 7 for Saturday
--	opening_time TIME,
--	closing_time TIME
--);

CREATE TABLE itineraries (
	itinerary_id SERIAL PRIMARY KEY,
	user_id INT NOT NULL REFERENCES users(user_id),
	itinerary_name VARCHAR (100) NOT NULL,
	starting_location_id INT NOT NULL REFERENCES landmarks(landmark_id),
	tour_date DATE NOT NULL CHECK (tour_date >= CURRENT_DATE)
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
	stop_order INT NOT NULL,
	CONSTRAINT PK_itineraries_landmarks PRIMARY KEY(itinerary_id, landmark_id)
);

CREATE TABLE landmarks_designations (
	landmark_id INT NOT NULL REFERENCES landmarks(landmark_id),
	designation_id INT NOT NULL REFERENCES designations(designation_id),
	CONSTRAINT PK_landmarks_designations PRIMARY KEY(landmark_id, designation_id)
);

ALTER TABLE users_itineraries ADD CONSTRAINT FK_users_itineraries_itinerary FOREIGN KEY(itinerary_id) REFERENCES itineraries(itinerary_id);
ALTER TABLE users_itineraries ADD CONSTRAINT FK_users_itineraries_user FOREIGN KEY(user_id) REFERENCES users(user_id);

ALTER TABLE itineraries_landmarks ADD CONSTRAINT FK_itineraries_landmarks_itinerary FOREIGN KEY(itinerary_id) REFERENCES itineraries(itinerary_id);
ALTER TABLE itineraries_landmarks ADD CONSTRAINT FK_itineraries_landmarks_landmark FOREIGN KEY(landmark_id) REFERENCES landmarks(landmark_id);

ALTER TABLE landmarks_designations ADD CONSTRAINT FK_landmarks_designations_landmark FOREIGN KEY(landmark_id) REFERENCES landmarks(landmark_id);
ALTER TABLE landmarks_designations ADD CONSTRAINT FK_landmarks_designations_designation FOREIGN KEY(designation_id) REFERENCES designations(designation_id);


COMMIT TRANSACTION;
