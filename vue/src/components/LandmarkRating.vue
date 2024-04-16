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
      previousRating: null
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
      this.currentRating = null;
      this.$emit('ratingCleared', { landmarkId: this.landmarkId });
    },

    retrieveRating() {
      ratingService.getRatingByLandmarkIdForLoggedInUser(this.$route.params.id).then(response => {
        this.currentRating = response.data.isGood;
      })
    }
  },

  created(){
    this.retrieveRating();
  }
}
</script>
