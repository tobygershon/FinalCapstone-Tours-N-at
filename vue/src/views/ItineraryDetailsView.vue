<!-- individual itinerary form to edit and delete the itinerary -->
<template>
    <div :="itinerary" class="landmark-container">
        <div>{{ itinerary.itineraryName }}</div>
        <div>{{ itinerary.startingLocationName }}</div>
        <div>{{ itinerary.tourDate }}</div>
        <router-link :to="{ name: 'landmarkDetailsView', params: { id: landmark.landmarkId } }"
            v-for="landmark in itinerary.listOfStops" :key="landmark.landmarkId">
            <div class="button-container"><button>
                    {{ landmark.landmarkName }}
                </button></div>
        </router-link>

        <div id="submitDiv">
            <router-link :to="{ name: 'tourRoute', params: { itineraryId: this.$route.params.itineraryId } }">
                <div id="getDirections">
                <button>Get My Directions</button>
            </div>
            </router-link>
        </div>

    </div>
</template>


<script>
import itineraryService from '../services/ItineraryService';


export default {

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
                tourId: '',
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


        updateCurrentItinerary() {
            itineraryService
                .updateItinerary(this.addItinerary)
                .then(response => {
                    if (response.status === 200) {
                        this.$store.commit(
                            'SET_NOTIFICATION',
                            {
                                message: `Itinerary ${this.addItinerary.id} was updated.`,
                                type: 'success'
                            }
                        );
                    }
                })
                .catch(error => {
                    this.handleErrorResponse(error, 'updating');
                });
        },

        handleErrorResponse(error, verb) {
            if (error.response) {
                this.$store.commit('SET_NOTIFICATION',
                    "Error " + verb + " itinerary. Response received was '" + error.response.statusText + "'.");
            } else if (error.request) {
                this.$store.commit('SET_NOTIFICATION', "Error " + verb + " itinerary. Server could not be reached.");
            } else {
                this.$store.commit('SET_NOTIFICATION', "Error " + verb + " itinerary. Request could not be created.");
            }
        },

        validateForm() {
            let msg = '';
            if (this.addItinerary.itineraryName.length === 0) {
                msg += 'The new itinerary must have a name. ';
            }
            if (this.addItinerary.startingLocationId.length === 0) {
                msg += 'The new card must have a starting location.';
            }
            if (msg.length > 0) {
                this.$store.commit('SET_NOTIFICATION', msg);
                return false;
            }
            return true;
        },

    },

    created() {
        this.getItinerary();
    }
}
</script>

<style>

#submitDiv {
    display: flex;
    justify-content: center;
    margin-top: 20px;
}
#getDirections {
    display: flex;
    justify-content: center;
    align-items: center;
    background-color: #2A2E34;
    color: #E9EAEC;
    border: solid #E4B61A 2px;
    width: 10rem;
    height: 3rem;
    border-radius: 10px;
    font-weight: 600;
}

#getDirections:hover {
    background-color: #0B0C0C;
}

a {
    justify-content: center;
}
</style>