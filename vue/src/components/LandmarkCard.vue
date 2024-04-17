<!-- individual card rep landmark with all data -->

<template>
    <div id="card">
        <div id="photo">
            <img v-if="photo != ''" :src="retrievePhoto(photo)" alt="photo">
        </div>
        <div id="info">
            <p id="name" >{{ landmark.landmarkName }}</p>
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
                    if (response.data.editorial_summary != null) {
                    this.description = response.data.editorial_summary.overview;
                    } else {
                        this.description = '';
                    }
                    if (response.data.photos != null) {
                    this.photo = response.data.photos[0].photo_reference;
                    } else {
                        this.photo = '';
                    }
                })
            }
        },

        retrievePhoto(photoRef) {

            const baseURL = 'https://maps.googleapis.com/maps/api/place/photo?maxwidth=95&photo_reference=';

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
    align-items: center;
    height: 100%;
    width: 100%;
}

/* #card {
    display: grid;
    grid-template-rows: 1fr 3fr;
    grid-template-columns: 1fr 3fr;
    grid-template-areas: "header header header"
                         "menu main events"
                         "footer footer footer";
} */

#name {
    font-size: .9rem;
    font-weight: 800;
}

#description {
    font-size: .75rem;
}

#photo {
    width: 20rem;
}

#info {
    min-width: 8rem;
    margin-left: 5px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
}
</style>


