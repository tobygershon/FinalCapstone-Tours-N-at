<!-- must be logged in: displays user's itineraries as a list
    can click individual itinerary to take to addItineraryview 
    and ability to create itineraries from here -->
<template>
    Tour Route View
    <ItineraryForm />
</template>
    
<script>
import itineraryService from '../services/ItineraryService';
import ItineraryForm from '../components/ItineraryForm.vue';


export default {
    methods: {
        
    },

    components: {
        ItineraryForm
    }
}


</script>