import axios from 'axios';
import { h } from 'vue';


export default {
    getItineraries() {
        return axios.get(`/itineraries`);
    },

    getItineraryById(itineraryId) {
        return axios.get(`/itineraries/${itineraryId}`);
    },

    getListOfPlaceUrlByItineraryId(itineraryId) {
        return axios.get(`/places/itineraries/${itineraryId}`)
    },

    createItinerary(itinerary) {
        return axios.post(`/itineraries`, itinerary);
    },

    addLandmarkToItinerary(landmarkId, itinerary) {
        return axios.put(`/landmarks/${landmarkId}/${itinerary.itineraryId}`, itinerary);
    },

    deleteLandmarkFromItinerary(landmarkId, itinerary) {
        return axios.delete(`/landmarks/${landmarkId}/${itinerary.itineraryId}`, itinerary);
    },

    updateItinerary(itinerary) {
        return axios.put(`itineraries/${itinerary.itineraryId}`, itinerary);
    },

    deleteItinerary(itineraryId) {
        return axios.delete(`itineraries/${itineraryId}`);
    }
}