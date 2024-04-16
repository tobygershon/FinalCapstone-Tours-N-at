import axios from 'axios';

export default {
    
    getRatingsByUser() {
        return axios.get(`/ratings`);
    },

    getRatingsByLandmarkId(landmarkId) {
        return axios.get(`/landmarks/${landmarkId}/ratings`);
    },

    getRatingByLandmarkIdForLoggedInUser(landmarkId) {
        return axios.get(`/landmarks/${landmarkId}/ratings/rated`)
    },

    createOrUpdateRating(landmarkId, isGood) {
        return axios.put(`/landmarks/${landmarkId}/ratings`, { isGood });
    },

    updateRating(ratingId, isGood) {
        return axios.put(`/ratings/${ratingId}`, { isGood });
    },

    deleteRating(ratingId) {
        return axios.delete(`/ratings/${ratingId}`);
    }

}
