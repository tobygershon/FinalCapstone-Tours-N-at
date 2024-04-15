<template>
    <div class="landmark-container">
        <div id="itinerary-form">
            <div>
                <label for="itineraryNameText">Itinerary Name:</label>
                <input type="text" name="itineraryNameText" id="itineraryNameText" v-model="editItinerary.itineraryName">
            </div>
            <div>
                <label for="startingPointText">Starting Location:</label>
                <input type="text" name="startingPointText" id="startingPointText"
                    v-model="editItinerary.startingLocationName">
            </div>
            <div>
                <label for="dateSelector">Tour Date:</label>
                <input type="date" id="dateSelector" v-model="editItinerary.tourDate" :min="minDate">
            </div>
        </div>

        <div v-for="landmark in itinerary.listOfStops" :key="landmark.landmarkId">

            <div class="button-container"><button>
                    {{ landmark.landmarkName }}
                </button></div>
            <button @click="deleteLandmarkFromItinerary(landmark.id)">Remove stop</button>
        </div>
        <div class="tooling-button-div">
            <div class="tooling-button">
                <button @click="updateItinerary">Save Itinerary</button>
            </div>
            <div class="tooling-button">
                <button @click="cancelItineraryForm">Cancel Changes</button>
            </div>
            <div class="tooling-button">
                <button v-if="isLoggedIn && isLoggedInUsersItinerary" @click="deleteItinerary">
                    Delete Itinerary
                </button>
            </div>
        </div>

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
            },

            removeLandmark: {
                itineraryId: '',
                landmarkId: ''
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
        updateItinerary() {
            if (!this.validateForm()) {
                return;
            }

            itineraryService
                .updateItinerary(this.editItinerary)
                .then(response => {
                    if (response.status >= 200 && response.status < 300) {
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

        cancelItineraryForm() {
            this.$router.push({ name: 'itineraryDetail', params: { itineraryId: this.editItinerary.itineraryId } });
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

        deleteLandmarkFromItinerary(landmarkId) {
            if (!this.validateForm()) {
                return;
            }
            const itineraryId = this.itinerary.itineraryId;
            itineraryService.deleteLandmarkFromItinerary(landmarkId, itineraryId)
                .then(response => {
                    if (response.status < 300 && response.status > 199) {
                        this.$store.commit(
                            'SET_NOTIFICATION',
                            {
                                message: `Your stop was removed from your itinerary.`,
                                type: 'success'
                            }
                        );
                    }
                })
                .catch(error => {
                    if (error.response) {
                        this.$store.commit('SET_NOTIFICATION',
                            "Error deleting landmark from itinerary. Response received was '" + error.response.statusText + "'.");
                    } else if (error.request) {
                        this.$store.commit('SET_NOTIFICATION', "Error deleting itinerary. Server could not be reached.");
                    } else {
                        this.$store.commit('SET_NOTIFICATION', "Error deleting itinerary. Request could not be created.");
                    }
                });
        }

    },
}

</script>

<style scoped>
.landmark-container {
    display: flex;
    flex-direction: column;
    width: 70vw;
}

#itinerary-form {
    display: flex;
    flex-direction: column;
    align-items: flex-start;
}
</style>