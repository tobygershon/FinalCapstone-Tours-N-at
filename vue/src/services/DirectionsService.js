import axios from 'axios';

export default {

    getDirections(itineraryId) {
        return axios.get(`/directions/${itineraryId}`);
    }
    
}