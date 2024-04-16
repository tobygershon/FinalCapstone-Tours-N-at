<!-- individual card rep landmark with all data -->

<template>
    <div id="card">
        <div id="photo">
            <img v-if="photo != ''" :src="retrievePhoto(photo)" alt="photo">
        </div>
        <div id="info">
            <p id="name">{{ landmark.landmarkName }}</p>
            <p id="description">{{ description }}</p>
        </div>
    </div>
</template>


<script>
import landmarkService from '../services/LandmarkService';

export default {

    props: ['landmark'],

    data() {
        return {
            description: '',
            photo: '',
            isLoading: true
        }
    },

    methods: {
        Loading() {
            this.isLoading = false;
        },

        getPlacesDataForLandmark() {
            if (!this.isLoading) {
                landmarkService.getLandmarkInfoFromPlaces(this.landmark.landmarkId).then(response => {
                    this.description = response.data.editorial_summary.overview;
                    this.photo = response.data.photos[0].photo_reference;
                })
            }
        },

        retrievePhoto(photoRef) {

            const baseURL = 'https://maps.googleapis.com/maps/api/place/photo?maxwidth=75&photo_reference=';

            const apiKey = '&key=AIzaSyBqJyZCzD-m22Izo98cXLx_PcND6cHoKWI';

            return (baseURL + photoRef + apiKey);

        }
    },

    created() {
        this.Loading();
        this.getPlacesDataForLandmark();
    }
}

</script>

<style scoped>
#card {
    display: flex;
    flex-direction: column;
}

#name {
    font-size: .9rem;
    font-weight: 600;
}

#description {
    font-size: .75rem;
}
</style>


