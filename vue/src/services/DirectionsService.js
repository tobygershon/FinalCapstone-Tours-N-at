import axios from 'axios';

const http = axios.create({
    baseUrl: "http://localhost:9000"
});

export default {

    getDirections(itineraryId) {
        return http.get(`/itineraries/${itineraryId}/directions`);
    }
}