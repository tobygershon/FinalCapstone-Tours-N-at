import axios from 'axios';
import { h } from 'vue';


export default {
    getItineraries() {
        return axios.get(`/itineraries`);
    },

    getItineraryById(itineraryId) {
        return axios.get(`/itineraries/${itineraryId}`);
    },

    createItinerary(itinerary) {
        return axios.post(`/itineraries`, itinerary);
    },

    updateItinerary(itinerary) {
        return axios.put(`itineraries/${itinerary.itineraryId}`, itinerary);
    },

    deleteItinerary(itineraryId) {
        return axios.delete(`itineraries/${itineraryId}`);
    }
}