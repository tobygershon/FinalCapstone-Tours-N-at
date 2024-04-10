import axios from 'axios';
import { h } from 'vue';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {
    getItineraries() {
        return http.get(`/itineraries`);
    },

    getItineraryById(itineraryId) {
        return http.get(`/itineraries/${itineraryId}`);
    },

    createItinerary(itinerary) {
        return http.post(`/itineraries`, itinerary);
    },

    updateItinerary(itinerary) {
        return http.put(`itineraries/${itinerary.id}`, itinerary);
    },

    deleteItinerary(itineraryId) {
        return http.delete(`itineraries/${itineraryId}`);
    }
}