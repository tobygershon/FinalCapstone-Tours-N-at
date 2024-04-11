import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

// DELETE this?
const googleDirections = axios.create({
    baseURL: "https://maps.googleapis.com/maps/api/directions/json"
})

export default {

    getDirections(itineraryId) {
        return http.get(`/directions/${itineraryId}`);
    },

    //Delete method?
    getGoogleDirections(destination, origin) {
        return googleDirections.get(`?destination=${destination}&origin=${origin}&key=AIzaSyBqJyZCzD-m22Izo98cXLx_PcND6cHoKWI`);
    }
}