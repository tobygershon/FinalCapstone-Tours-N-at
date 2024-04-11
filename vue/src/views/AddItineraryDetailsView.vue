<template>
    <router-link :to="{ name: 'itineraryList'}">
        <div class="returnButton">
           <button>Back to Itineraries</button>
        </div>
    </router-link>
    <ItineraryForm />
</template>

<script>
import ItineraryForm from '../components/ItineraryForm.vue';


export default {

    components: {
        ItineraryForm,
    }

}
</script>