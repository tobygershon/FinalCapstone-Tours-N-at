BEGIN TRANSACTION;

INSERT INTO itineraries_landmarks (itinerary_id, landmark_id, stop_order) VALUES (1, 48, 1);
INSERT INTO itineraries_landmarks (itinerary_id, landmark_id, stop_order) VALUES (1, 15, 2);
INSERT INTO itineraries_landmarks (itinerary_id, landmark_id, stop_order) VALUES (1, 1, 3);
INSERT INTO itineraries_landmarks (itinerary_id, landmark_id, stop_order) VALUES (1, 23, 4);
INSERT INTO itineraries_landmarks (itinerary_id, landmark_id, stop_order) VALUES (1, 6, 5);
INSERT INTO itineraries_landmarks (itinerary_id, landmark_id, stop_order) VALUES (1, 13, 6);

COMMIT TRANSACTION;