import axios from 'axios';

export default {
    
    getRatingsByUser() {
        return axios.get(`/ratings`);
    },

    getRatingsByLandmarkId(landmarkId) {
        return axios.get(`/landmarks/${landmarkId}/ratings`);
    },

    createRating(landmarkId) {
        return axios.post(`/landmarks/${landmarkId}/ratings`);
    },

    updateRating(ratingId) {
        return axios.put(`/ratings/${ratingId}`);
    },

    deleteRating(ratingId) {
        return axios.delete(`/ratings/${ratingId}`);
    }

}
