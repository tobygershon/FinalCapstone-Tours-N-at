import axios from 'axios';

export default {
    
    getRatingsByUserId(userId) {
        return axios.get(`/ratings/${userId}`);
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
