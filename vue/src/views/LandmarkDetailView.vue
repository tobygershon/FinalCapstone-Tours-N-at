<template>
  <div class="landmark-container">
    <h2>{{ landmark.landmarkName }}</h2>
    <p>Address: {{ landmark.address }}</p>
    <p>Description: {{ placesData.editorial_summary.overview }}</p>
    <p>Designation: {{ formattedDesignations }}</p>
    <p v-for="(day, index) in hoursArray" :key="index">Hours: {{ day }}</p>
    <p>Ratings: {{ landmark.ratings }}</p>
    <button @click="toggleDropdown"><i class="fas fa-plus"></i> Add to Itinerary</button> <br>
    <select v-if="showDropdown">
      <option v-for="itin in userItineraries" :key="itin.itineraryId" :value="itin.itineraryId">{{ itin.itineraryName }}</option>
    </select>
    <div class="button-container">
      <button class="rating-button">
        <i class="fas fa-thumbs-up"></i> Rate Up
      </button>
      <button>
        <i class="fas fa-thumbs-down"></i> Rate Down
      </button><br>
    </div>

    <router-link to="/landmarks"><i class="fas fa-arrow-left">Back</i></router-link>
  </div>
</template>

<script>
import landmarkService from '../services/LandmarkService.js';
import itineraryService from '../services/ItineraryService.js';


export default {
  data() {
    return {
      landmark: {},
      designations: [],
      placesData: {},
      showDropdown: false,
      userItineraries: []
    };
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

    retrievePlacesAPIData() {
      landmarkService.getLandmarkInfoFromPlaces(this.$route.params.id).then(response => {

        this.placesData = response.data;
      })
    },

    toggleDropdown() {
      this.showDropdown = !this.showDropdown;
    },

    retrieveUserItineraries() {
      itineraryService.getItineraries().then(response => {
        this.userItineraries = response.data;
        console.log(this.userItineraries);
      }).catch(error => {
        if (error.response) {
          this.$store.commit('SET_NOTIFICATION',
            "Error getting itineraries. Response received was ''" + error.response.statusText + "'.");
        } else if (error.request) {
          this.$store.commit('SET_NOTIFICATION', "Error getting itineraries. Server could not be reached.");
        } else {
          this.$store.commit('SET_NOTIFICATION', "Error getting itineraries. Request could not be created.");
        }
      });
    }

  },

  created() {
    this.retrieveCard();
    this.retrieveDesignations();
    this.retrievePlacesAPIData();
    this.retrieveUserItineraries();
  },
};
</script>
