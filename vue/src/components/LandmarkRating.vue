<!-- thumbs up/down for landmarks and tracking the data users enter about if they liked it -->
<template>
    <div class="button-container">
      <button
        :class="{ 'active': currentRating === true }"
        @click="rate(true)"
        class="rating-button">
        <i class="fas fa-thumbs-up"></i> Rate Up
      </button>
      <button
        :class="{ 'active': currentRating === false }"
        @click="rate(false)">
        <i class="fas fa-thumbs-down"></i> Rate Down
      </button><br>
      <button
        @click="clearRating"
        class="clear-button">
        <i class="fas fa-times"></i> Clear
      </button><br>
    </div>
  </template>


  <script>
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
        currentRating: null 
      };
    },
    methods: {
      rate(isGood) {
        this.currentRating = isGood;
        this.$emit('rated', { landmarkId: this.landmarkId, isGood });
      },
      clearRating() {
        this.currentRating = null;
        this.$emit('ratingCleared', { landmarkId: this.landmarkId });
      }
    }
  }
  </script>
