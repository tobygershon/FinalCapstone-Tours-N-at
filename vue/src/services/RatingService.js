import axios from 'axios';

export default {
    
    getRatingsByUser() {
        return axios.get(`/ratings`);
    },

    getRatingsByLandmarkId(landmarkId) {
        return axios.get(`/landmarks/${landmarkId}/ratings`);
    },

    createRating(landmarkId, isGood) {
        return axios.post(`/landmarks/${landmarkId}/ratings`, { isGood });
    },

    updateRating(ratingId, isGood) {
        return axios.put(`/ratings/${ratingId}`, { isGood });
    },

    deleteRating(ratingId) {
        return axios.delete(`/ratings/${ratingId}`);
    }

}
