<!-- thumbs up/down for landmarks and tracking the data users enter about if they liked it -->
<template>
  <div class="button-container">

    <button :class="{ 'active': currentRating === true }" @click="rate(true)" class="rating-button">
      <i class="fas fa-thumbs-up"></i> Rate Up
    </button>

    <button :class="{ 'active': currentRating === false }" @click="rate(false)" class="rating-button">
      <i class="fas fa-thumbs-down"></i> Rate Down
    </button><br>

    <button @click="clearRating" class="clear-button">
      <i class="fas fa-times"></i> Clear
    </button><br>

  </div>
</template>

<script>
import ratingService from '../services/RatingService';

export default {
  name: 'RatingComponent',

  props: {
    landmarkId: {
      type: Number,
      required: true
    }
  },

  data() {
    return {
      currentRating: null,
      ratingId: ''
    };
  },
  methods: {
    rate(isGood) {
      this.currentRating = isGood;
      ratingService.createOrUpdateRating(this.landmarkId, isGood)
        .then(response => {
          this.$emit('rated', response.data);
        })
        .catch(error => {
          console.error('Failed to post rating:', error);
        });
    },

    clearRating() {
      ratingService.deleteRating(this.ratingId).then(response => {
        this.$store.commit('SET_NOTIFICATION',
          {
            message: 'Rating has been deleted',
            type: 'success'
          });
          this.currentRating = null;
      })
        .catch(error => {
          if (error.response) {
            this.$store.commit('SET_NOTIFICATION',
              "Error deleting rating. Response received was '" + error.response.statusText + "'.");
          } else if (error.request) {
            this.$store.commit('SET_NOTIFICATION', "Error deleting rating. Server could not be reached.");
          } else {
            this.$store.commit('SET_NOTIFICATION', "Error deleting rating. Request could not be created.");
          }
        });
    },

    retrieveRating() {
      ratingService.getRatingByLandmarkIdForLoggedInUser(this.$route.params.id).then(response => {
        this.currentRating = response.data.isGood;
        this.ratingId = response.data.ratingId;
      })
    }

  },

  created() {
    this.retrieveRating();
  }

}
</script>
