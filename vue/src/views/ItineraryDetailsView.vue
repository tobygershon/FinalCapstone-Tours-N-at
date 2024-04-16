<!-- individual itinerary form to edit and delete the itinerary -->
<template>
    <div :="itinerary" class="itinerary-container">
        <div>{{ itinerary.itineraryName }}</div>
        <div>{{ itinerary.startingLocationName }}</div>
        <div>{{ itinerary.tourDate }}</div>
        <router-link :to="{ name: 'landmarkDetailsView', params: { id: landmark.landmarkId } }"
            v-for="landmark in itinerary.listOfStops" :key="landmark.landmarkId">
            <div class="button-container"><button>
                    {{ landmark.landmarkName }}
                </button></div>
        </router-link>


        <div id="submitDiv" class="tooling-button-div">
            <router-link :to="{ name: 'tourRoute', params: { itineraryId: this.$route.params.itineraryId } }">
                <div id="getDirections" class="tooling-button">
                    <button>Get My Directions</button>
                </div>
            </router-link> &nbsp;&nbsp;
            <router-link :to="{ name: 'itineraryList' }">
                <div  class="tooling-button">
                    <button>Back to Itineraries</button>
                </div>
            </router-link> &nbsp;&nbsp;
            <router-link
                :to="{ name: 'editItineraryDetailsView', params: { itineraryId: this.$route.params.itineraryId } }">
                <div class="tooling-button"><button>
                        Edit Itinerary
                    </button></div>
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

<style scoped>
.itinerary-container {
    font-weight: 600;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    width: 70vw;
    height: auto;
}
.tooling-button-div {
    display: flex;
    justify-content: center;
    margin-top: 20px;
    justify-content: space-around;
}

.tooling-button {
    display: flex;
    justify-content: center;
    align-items: center;
    background-color: #2A2E34;
    color: #E9EAEC;
    border: solid #E4B61A 2px;
    width: 9.75rem;
    height: 3rem;
    border-radius: 10px;
    font-weight: 600;
}

.tooling-button:hover {
    background-color: #0B0C0C;
}

a {
    justify-content: center;
}
.itinerary-container {

}

#itinerary-form {
    display: flex;
    flex-direction: column;
    align-items: flex-start;
}



.button-container button {
    width: 22rem;
    display: flex;
    flex-grow: 1;
    justify-self: center;
    text-align: center;
    justify-content: center;

}

</style>