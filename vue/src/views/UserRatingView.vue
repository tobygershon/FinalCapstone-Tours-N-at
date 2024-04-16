<template>
    <div class="tooling-button-div">
        <button class="tooling-button" @click="retrieveRatingsByUser">See All Reviews</button>&nbsp;&nbsp;
        <button class="tooling-button" @click="showThumbsUp">See Thumbs Up Reviews</button>&nbsp;&nbsp;
        <button class="tooling-button" @click="showThumbsDown">See Thumbs Down Reviews</button>
    </div>
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
            constantRatings: []
        }
    },

    methods: {
        retrieveRatingsByUser() {
            ratingService.getRatingsByUser().then(response => {
                this.userRatings = response.data;
                this.constantRatings = response.data;
            }).catch(error => {
                if (error.response) {
                    this.$store.commit('SET_NOTIFICATION',
                        "Error getting ratings. Response received was ''" + error.response.statusText + "'.");
                } else if (error.request) {
                    this.$store.commit('SET_NOTIFICATION', "Error getting ratings. Server could not be reached.");
                } else {
                    this.$store.commit('SET_NOTIFICATION', "Error getting ratings. Request could not be created.");
                }
            });
        },

        showThumbsUp() {
            this.userRatings = this.constantRatings.filter(rating => rating.isGood === true);
        },

        showThumbsDown() {
            this.userRatings = this.constantRatings.filter(rating => rating.isGood === false);
        },
    },

    created() {
        this.retrieveRatingsByUser();
    }
}
</script>
