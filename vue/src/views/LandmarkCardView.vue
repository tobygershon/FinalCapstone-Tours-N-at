<!-- view landmark details: displays individual landmark card with info -->

<template>
    <LandmarkCard />
</template>


<script>

import landmarkService from '../services/LandmarkService';
import LandmarkCard from '../components/LandmarkCard.vue';

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

        // retrieveCard() {
        //     const id = this.$route.params.id;
        //     landmarkService.getLandmarkById(id).then(response => {
        //         this.landmark = response.data;

        //     })
        // }
    }
}

</script>