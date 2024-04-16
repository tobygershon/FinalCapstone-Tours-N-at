import axios from 'axios';



export default {

    getAllLandmarks() {
        return axios.get('/landmarks');
    },

    getLandmarksByDesignation(designation) {
        return axios.get(`/landmarks/designation/${designation}`);
    },

    getLandmarkById(landmarkId) {
        return axios.get(`/landmarks/${landmarkId}`);
    },

    getLandmarksByName(landmarkName) {
        return axios.get(`/landmarks/search/${landmarkName}`);
    },
    
    getDesignationsForLandmark(landmarkId) {
        return axios.get(`/landmarks/${landmarkId}/designation`);
    },

    getLandmarkInfoFromPlaces(landmarkId) {
        return axios.get(`/places/${landmarkId}`);
    }
}