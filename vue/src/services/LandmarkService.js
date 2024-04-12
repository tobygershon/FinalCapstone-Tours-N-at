import axios from 'axios';

const apiKey = '&key=AIzaSyBqJyZCzD-m22Izo98cXLx_PcND6cHoKWI';
const http = axios.create({
    baseURL: 'https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photo_reference='
})

// https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photo_reference=ATJ83zhSSAtkh5LTozXMhBghqubeOxnZWUV2m7Hv2tQaIzKQJgvZk9yCaEjBW0r0Zx1oJ9RF1G7oeM34sQQMOv8s2zA0sgGBiyBgvdyMxeVByRgHUXmv-rkJ2wyvNv17jyTSySm_-_6R2B0v4eKX257HOxvXlx_TSwp2NrICKrZM2d5d2P4q&key=AIzaSyBqJyZCzD-m22Izo98cXLx_PcND6cHoKWI

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
    },

    getPhotosForLandmark(googlePhotoRef) {
        return http.get('googlePhotoRef' + apiKey);
    }
}