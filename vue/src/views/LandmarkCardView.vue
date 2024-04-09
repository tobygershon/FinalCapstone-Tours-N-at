<!-- view landmark details: displays individual landmark card with info -->

<template>

    <LandmarkCard :landmark="landmark"/>

    <div class="button">
        <router-link v-to>Back to Search</router-link>
        <button>Add to Itinerary</button>
    </div>
</template>


<script>
import LandmarkCard from '../components/LandmarkCard.vue';
import landmarkService from '../services/LandmarkService';

export default {
    components: {
        LandmarkCard
    },

    data() {
        return {
            landmark: {
                name: '',
                address: '',
                hours: '',
                designation: ''
            }
        }
    },

    methods: {

        retrieveCard() {
            const id = this.$route.params.id;
            landmarkService.getLandmarkById(id).then(response => {
                this.landmark = response.data;
    
            })
        }
    }
}

</script>