<!-- must be logged in: displays user's itineraries as a list
    can click individual itinerary to take to add Itinerary View 
    and ability to create itineraries from here -->
<template>
    <router-link :to="{ name: 'addItineraryDetailsView' }">
        <div class="addButton">
            <button>Add Itinerary</button>
        </div>
    </router-link>
    
    <ItineraryList v-if="!isLoading" :itineraries="itineraries" />
</template>
    
<script>
import itineraryService from '../services/ItineraryService';
import ItineraryList from '../components/ItineraryList.vue';


export default {

    components: {
        ItineraryList
    },

    data() {
        return {
            itineraries: [],

            isLoading: true,
        }
    },

    methods: {
        retrieveItineraries() {
            itineraryService.getItineraries().then(response => {
                this.itineraries = response.data;
                this.isLoading = false;
            }).catch(error => {
                if (error.response) {
                    this.$store.commit('SET_NOTIFICATION',
                        "Error getting itineraries. Response received was ''" + error.response.statusText + "'.");
                } else if (error.request) {
                    this.$store.commit('SET_NOTIFICATION', "Error getting itineraries. Server could not be reached.");
                } else {
                    this.$store.commit('SET_NOTIFICATION', "Error getting itineraries. Request could not be created.");
                }
            });
        }
    },

    created() {
        this.retrieveItineraries();
    }

}


</script>