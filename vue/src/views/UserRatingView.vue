<template>
    <div v-for="rating in userRatings" :key="rating.id">
        <Rating :rating="rating" />
    </div>
</template>

<script>
import Rating from '../components/Rating.vue';
import ratingService from '../services/RatingService';

export default {
    components: {
        Rating,
    },

    data() {
        return {
            userRatings: [],
        }
    },

    methods: {
        async ratingsByUserId() {
            try {
                const response = await ratingService.getRatingsByUserId();
                this.userRatings = response.data;
            } catch (error) {
                if (error.response) {
                    this.$store.commit('SET_NOTIFICATION',
                        "Error getting points of interest. Response received was '" + error.response.statusText + "'.");
                } else if (error.request) {
                    this.$store.commit('SET_NOTIFICATION', "Error getting points of interest. Server could not be reached.");
                } else {
                    this.$store.commit('SET_NOTIFICATION', "Error getting points of interest. Request could not be created.");
                }
            }
        },
    },

    created() {
        this.ratingsByUserId();
    }
}
</script>
