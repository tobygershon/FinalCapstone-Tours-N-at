<!-- form to create a new itinerary: need name, date, and starting point min -->
<template>
    <div>
        <label for="itineraryName">Name Your Itinerary:</label>
        <input type="text" name="itineraryName" id="itineraryNameText" placeholder="Itinerary Name" v-model="itineraryName">
    </div>
    <div>
        <label for="startingPoint">Choose Your Starting Location:</label>
        <input type="text" name="startingPoint" id="startingPointText" placeholder="Starting Location"
            v-model="startingLocation">
    </div>
    <div>
        <label for="dateSelector">Select a Tour Date:</label>
        <input type="date" id="dateSelector" v-model="selectedDate" :min="getCurrentDate">
    </div>
    <div>
        <input type="button" @click="submitItinerary" value="Create Itinerary">
    </div>
</template>
  
<script>
import itineraryService from '../services/ItineraryService';

export default {

    components: {

    },

    data() {
        return {
            editItinerary: {
                id: '',
                itineraryName: '',
                startingLocation: '',
                selectedDate: '',
            }
        }
    },

    methods: {
        submitItinerary() {
            if (!this.validateForm()) {
                return;
            }
            if (this.editItinerary.id === 0) {
                // add
                itineraryService
                    .createItinerary(this.editItinerary)
                    .then(response => {
                        if (response.status === 201) {
                            this.$store.commit(
                                'SET_NOTIFICATION',
                                {
                                    message: 'A new itinerary was added.',
                                    type: 'success'
                                }
                            );
                        }
                    })
                    .catch(error => {
                        this.handleErrorResponse(error, 'adding');
                    });
            } else {
                itineraryService
                    .updateItinerary(this.editItinerary)
                    .then(response => {
                        if (response.status === 200) {
                            this.$store.commit(
                                'SET_NOTIFICATION',
                                {
                                    message: `Itinerary ${this.editItinerary.id} was updated.`,
                                    type: 'success'
                                }
                            );
                        }
                    })
                    .catch(error => {
                        this.handleErrorResponse(error, 'updating');
                    });
            }
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
            if (this.editItinerary.itineraryName.length === 0) {
                msg += 'The new itinerary must have a name. ';
            }
            if (this.editItinerary.startingLocationId.length === 0) {
                msg += 'The new card must have a starting location.';
            }
            if (msg.length > 0) {
                this.$store.commit('SET_NOTIFICATION', msg);
                return false;
            }
            return true;
        },

    }
}
</script>
