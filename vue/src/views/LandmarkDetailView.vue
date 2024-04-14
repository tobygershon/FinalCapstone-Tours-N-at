<template>
  <div class="landmark-container">
    <h2>{{ landmark.landmarkName }}</h2>
    <p>Address: {{ landmark.address }}</p>
    <p>Description: {{ description }}</p>
    <p>Designation: {{ formattedDesignations }}</p>
    <p v-for="(day, index) in hoursArray" :key="index">Hours: {{ day }}</p>
    <p>Ratings: {{ landmark.ratings }}</p>
    <button><i class="fas fa-plus"></i> Add to Itinerary</button><br>
    <div class="button-container">
      <button class="rating-button">
        <i class="fas fa-thumbs-up"></i> Rate Up
      </button>
      <button>
        <i class="fas fa-thumbs-down"></i> Rate Down
      </button><br>
    </div>

    <router-link to="/landmarks"><i class="fas fa-arrow-left">Back</i></router-link>

    <div id="landmarkPhotos" v-for="(photo, index) in photos" :key="index">

      <img :src="retrievePhoto(photo.photo_reference)" alt="landamark photos">

    </div>

  </div>
</template>

<script>

import landmarkService from '../services/LandmarkService';


export default {
  data() {
    return {
      landmark: {},
      designations: [],
      placesData: {}
    };
  },


  computed: {
    formattedDesignations() {
      return this.designations.map(d => d.designationName).join(', ');
    },

    hoursArray() {
      if (this.placesData.current_opening_hours.hours != null) {
        return this.placesData.current_opening_hours.hours;
      }
      return '';
    },

    description() {
      if (this.placesData.editorial_summary.overview != null) {
        return this.placesData.editorial_summary.overview;
      }
      return '';
    },

    photos() {
      return this.placesData.photos;
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

    retrievePlacesAPIData() {
      landmarkService.getLandmarkInfoFromPlaces(this.$route.params.id).then(response => {

        this.placesData = response.data;
      })
    },

    retrievePhoto(photoRef) {

      const baseURL = 'https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photo_reference=';

      const apiKey = '&key=AIzaSyBqJyZCzD-m22Izo98cXLx_PcND6cHoKWI';

      return (baseURL + photoRef + apiKey);
    }
  },

  created() {
    this.retrieveCard();
    this.retrieveDesignations();
    this.retrievePlacesAPIData();
  },
};
</script>

<styles scoped>




</styles>


