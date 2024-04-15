<template>
    <UpdateItineraryForm :itinerary="itinerary"/>
</template>

<script>
import UpdateItineraryForm from '../components/UpdateItineraryForm.vue';
import itineraryService from '../services/ItineraryService';

export default {

    components: {
        UpdateItineraryForm,
    },

    data() {
        return {

            updateItinerary: {

            },

            itinerary: {
                itineraryId: '',
                userId: '',
                itineraryName: '',
                startingLocationId: '',
                startingLocationName: '',
                tourDate: '',
                listOfStops: []
            }
        }
    },

    methods: {

        getItinerary() {
            const id = this.$route.params.itineraryId;
            itineraryService.getItineraryById(id).then(response => {
                this.itinerary = response.data;
            }).catch(error => {
                this.handleErrorResponse(error, 'retrieving');
            });
        },

    },

    created() {
        this.getItinerary();
    }
}

</script>