<!-- form to create a new itinerary: need name, date, and starting point min -->
<template>
    <div class="landmark-container">
        <div>
            <label for="itineraryName">Name Your Itinerary:</label>
            <input type="text" name="itineraryName" id="itineraryNameText" placeholder="Itinerary Name"
                v-model="addItinerary.itineraryName">
        </div>
        <div>
            <label for="startingPoint">Choose Your Starting Location:</label>
            <input type="text" name="startingPoint" id="startingPointText" placeholder="Starting Location"
                v-model="addItinerary.startingLocation">
        </div>
        <div>
            <label for="dateSelector">Select a Tour Date:</label>
            <input type="date" id="dateSelector" v-model="addItinerary.date" :min="minDate">
        </div>
        <div class="tooling-button-div">
            <div class="tooling-button"><button @click="submitItinerary">Save</button></div>
            <div class="tooling-button"><button>Cancel</button></div>
        </div>
    </div>
</template>
  
<script>
import itineraryService from '../services/ItineraryService';

export default {

    components: {

    },

    data() {
        return {
            addItinerary: {
                itineraryId: 0,
                itineraryName: '',
                startingLocation: '',
                date: '',
            },

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

    },

    methods: {



        submitItinerary() {
            if (!this.validateForm()) {
                return;
            }

            itineraryService
                .createItinerary(this.addItinerary)
                .then(response => {
                    if (response.data === null) {
                        alert('Your starting location could not be found.  Please enter a valid address.');
                    }
                    if (response.status === 201) {
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

        validateForm() {
            let msg = '';
            if (this.addItinerary.itineraryName.length === 0) {
                msg += 'The new itinerary must have a name. ';
            }
            if (this.addItinerary.startingLocation.length === 0) {
                msg += 'The new itinerary must have a starting location.';
            }
            if (this.addItinerary.date.length === 0) {
                msg += 'The new itinerary must have a date.';
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
