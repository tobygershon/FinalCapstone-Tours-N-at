<template>
    <div class="button-container">
        <button v-if="isLoggedIn && isLoggedInUsersItinerary" @click="deleteItinerary">
            Delete Itinerary
        </button>
    </div>
    <div>
        <label for="itineraryNameText">Itinerary Name:</label>
        <input type="text" name="itineraryNameText" id="itineraryNameText" v-model="editItinerary.itineraryName">
    </div>
    <div>
        <label for="startingPointText">Starting Location:</label>
        <input type="text" name="startingPointText" id="startingPointText" v-model="editItinerary.startingLocationName">
    </div>
    <div>
        <label for="dateSelector">Tour Date:</label>
        <input type="date" id="dateSelector" v-model="editItinerary.tourDate" :min="minDate">
    </div>
    <div>
        <input type="button" @click="updateItinerary" value="Save">
        <input type="button" value="Cancel">
    </div>
</template>
  
<script>
import itineraryService from '../services/ItineraryService';

export default {

    props: {
        itinerary: {
            type: Object,
            required: true,
        }
    },

    data() {
        return {
            editItinerary: {
                itineraryId: this.itinerary.itineraryId,
                userId: this.itinerary.userId,
                itineraryName: this.itinerary.itineraryName,
                startingLocationId: this.itinerary.startingLocationId,
                startingLocationName: this.itinerary.startingLocationName,
                tourDate: this.itinerary.tourDate,
                listOfStops: this.itinerary.listOfStops
            }

        }
    },

    computed: {

        // Compute today's date in the format 'YYYY-MM-DD'
        minDate() {
            const today = new Date();
            const year = today.getFullYear();
            const month = String(today.getMonth() + 1).padStart(2, '0');
            const day = String(today.getDate()).padStart(2, '0');
            return `${year}-${month}-${day}`;
        },

        isLoggedInUsersItinerary() {
            return this.itinerary.userId === this.$store.state.user.id;
        },

        isLoggedIn() {
            return this.$store.getters.isLoggedIn;
        },

    },

    methods: {
        submitItinerary() {
            if (!this.validateForm()) {
                return;
            }

            itineraryService
                .updateItinerary(this.editItinerary)
                .then(response => {
                    if (response.status >= 200 && response.status < 300 ) {
                        this.$store.commit(
                            'SET_NOTIFICATION',
                            {
                                message: 'A new itinerary was added.',
                                type: 'success'
                            }
                        );
                        this.$router.push({ name: 'itineraryList', params: { id: this.addItinerary.itineraryId } });
                    }
                })
                .catch(error => {
                    this.handleErrorResponse(error, 'adding');
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

        deleteItinerary() {
            if (confirm("Are you sure you want to delete the itinerary?")) {

                itineraryService.deleteItinerary(this.itinerary.itineraryId)
                    .then(response => {
                        this.$store.commit('SET_NOTIFICATION',
                            {
                                message: 'Itinerary has been deleted',
                                type: 'success'
                            });
                        this.$router.push({ name: 'itineraryList' })
                    }).catch(error => {
                        if (error.response) {
                            this.$store.commit('SET_NOTIFICATION',
                                "Error deleting itinerary. Response received was '" + error.response.statusText + "'.");
                        } else if (error.request) {
                            this.$store.commit('SET_NOTIFICATION', "Error deleting itinerary. Server could not be reached.");
                        } else {
                            this.$store.commit('SET_NOTIFICATION', "Error deleting itinerary. Request could not be created.");
                        }
                    })
            }
        },

        validateForm() {
            let msg = '';
            if (this.editItinerary.itineraryName.length === 0) {
                msg += 'The itinerary must have a name.';
            }
            if (this.editItinerary.startingLocationName.length === 0) {
                msg += 'The itinerary must have a starting location.';
            }
            if (this.editItinerary.date.length === 0) {
                msg += 'The itinerary must have a date of today or later.';
            }
            if (msg.length > 0) {
                this.$store.commit('SET_NOTIFICATION', msg);
                return false;
            }
            return true;
        },

    },
}

</script>
