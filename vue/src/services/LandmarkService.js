import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    getAllLandmarks() {
        return http.get('/landmarks');
    },

    getLandmarksByDesignation(designation) {
        return http.get(`/landmarks/designation/${designation}`);
    },

    getLandmarkById(landmarkId) {
        return http.get(`/landmarks/${landmarkId}`);
    },

    getLandmarksByName(landmarkName) {
        return http.get(`/landmarks/search/${landmarkName}`);
    },
    
}