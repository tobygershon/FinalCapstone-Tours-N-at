<!-- view landmark details: displays individual landmark card with info -->

<template>
 Landmark Name:
 {{ landmark.landmarkName }}
</template>


<script>

import landmarkService from '../services/LandmarkService';


export default {

    components: {
    
    },

    data() {
        return {
            landmark: {}
            }
        },

    methods: {

        retrieveCard() {
            const id = this.$route.params.id;
            landmarkService.getLandmarkById(id).then(response => {
                this.landmark = response.data;

            })
        }
    },

    created() {
        this.retrieveCard();
    }
}


</script>