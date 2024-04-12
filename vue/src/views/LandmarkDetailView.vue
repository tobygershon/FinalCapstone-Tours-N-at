<template>
  <div class="landmark-container">
    <h2>{{ landmark.landmarkName }}</h2>
    <p>Address: {{ landmark.address }}</p>
    <p>Description: {{ placesData.editorial_summary.overview }}</p>
    <p>Designation: {{ formattedDesignations }}</p>
    <p v-for="(day, index) in hoursArray" :key="index">Hours: {{ day }}</p>
    <p>Ratings: {{ landmark.ratings }}</p>
    <button><i class="fas fa-plus"></i> Add to Itinerary</button><br>
    <ratingComponent :landmarkId="landmark.landmarkId" @rated="handleRating" />
    <router-link to="/landmarks"><i class="fas fa-arrow-left">Back</i></router-link>
  </div>
</template>

<script>

import landmarkService from '../services/LandmarkService';
import ratingComponent from '../components/LandmarkRating.vue';


export default {
  data() {
    return {
      landmark: {},
      designations: [],
      placesData: {}
    };
  },

  components: {
    ratingComponent
  },

  computed: {
    formattedDesignations() {
      return this.designations.map(d => d.designationName).join(', ');
    },

    hoursArray() {
      return this.placesData.current_opening_hours.hours;
    }
  },

  methods: {
    retrieveCard() {
      const id = this.$route.params.id;
      landmarkService.getLandmarkById(id).then((response) => {
        this.landmark = response.data;
      });
    },

    retrieveDesignations() {
      landmarkService.getDesignationsForLandmark(this.$route.params.id).then(response => {
        console.log("Fetched designations:", response.data);
        this.designations = response.data;
      }).catch(error => {
        if (error.response) {
          this.$store.commit('SET_NOTIFICATION',
            "Error getting designations. Response received was ''" + error.response.statusText + "'.");
        } else if (error.request) {
          this.$store.commit('SET_NOTIFICATION', "Error getting designations. Server could not be reached.");
        } else {
          this.$store.commit('SET_NOTIFICATION', "Error getting designations. Request could not be created.");
        }
      });
    },

    handleRating(ratingData) {
      landmarkService.createRating(ratingData.landmarkId, ratingData.isGood)
        .then(response => {
          console.log('Rating successfully created:', response.data);
          this.retrieveCard();
        })
        .catch(error => {
          console.error('Error creating rating:', error);
        });
    },

    handleUpdateRating(rating) {
      landmarkService.updateRating(rating.id, rating.isGood)
        .then(response => {
          console.log('Rating successfully updated:', response.data);
        })
        .catch(error => {
          console.error('Error updating rating:', error);
        });
    },

    retrievePlacesAPIData() {
      landmarkService.getLandmarkInfoFromPlaces(this.$route.params.id).then(response => {

        this.placesData = response.data;
      })
    }

  },

  created() {
    this.retrieveCard();
    this.retrieveDesignations();
    this.retrievePlacesAPIData();
  },
};
</script>


