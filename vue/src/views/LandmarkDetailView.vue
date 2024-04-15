<template>
  <div class="landmark-container">
    <h2>{{ landmark.landmarkName }}</h2>
    <p>Address: {{ landmark.address }}</p>
    <p>Description: {{ description }}</p>
    <a :href="website" :target="'_blank'">Website</a>&nbsp;|&nbsp;
    <a :href="url" :target="'_blank'">Interactive Map</a>
    <p>Designation: {{ formattedDesignations }}</p>
    <p v-for="(day, index) in hoursArray" :key="index">Hours: {{ day }}</p>
    <!-- <p>Ratings: {{ landmark.ratings }}</p> -->
    <button v-if="isLoggedIn" @click="toggleDropdown"><i class="fas fa-plus"></i> Add to Itinerary</button> <br>
    <div v-if="showDropdown">
      <select v-model="editItinerary.itineraryId">
        <option v-for="itin in userItineraries" :key="itin.itineraryId" :value="itin.itineraryId">{{ itin.itineraryName }}
        </option>
      </select>
      <input type="button" @click="addToItinerary()" value="Go!">
    </div>
    <div v-if="notification && isLoggedIn">
      {{ notification.message }}
    </div>
    <LandmarkRating v-if="isLoggedIn" :landmark-id="landmark.landmarkId" @rated="handleRating" />

    <router-link to="/landmarks"><i class="fas fa-arrow-left">Back</i></router-link>

    <div id="landmarkPhotos" v-for="(photo, index) in photos" :key="index">

      <img :src="retrievePhoto(photo.photo_reference)" alt="landmark photos">

    </div>

  </div>
</template>

<script>
import landmarkService from '../services/LandmarkService.js';
import ratingService from '../services/RatingService.js';
import itineraryService from '../services/ItineraryService.js';
import LandmarkRating from '../components/LandmarkRating.vue';

export default {
  components: {
    LandmarkRating
  },

  data() {
    return {
      landmark: {},
      designations: [],
      placesData: {},
      showDropdown: false,
      userItineraries: [],
      editItinerary: {
        itineraryId: '',
        landmarkId: this.$route.params.id
      },
      rated: {},
    };
  },


  computed: {

    notification() {
      return this.$store.state.notification;
    },

    formattedDesignations() {
      return this.designations.map(d => d.designationName).join(', ');
    },

    hoursArray() {
      if (this.placesData.current_opening_hours != null) {
        return this.placesData.current_opening_hours.hours;
      }
      return '';
    },

    description() {
      if (this.placesData.editorial_summary != null) {
        return this.placesData.editorial_summary.overview;
      }
      return '';
    },

    photos() {
      const emptyArray = [];
      if (this.placesData.photos == null) {
        return emptyArray;
      }
      return this.placesData.photos;
    },

    website() {
      if (this.placesData.website != null) {
        return this.placesData.website;
      }
      return '';
    },

    url() {
      if (this.placesData.url != null) {
        return this.placesData.url;
      }
      return '';
    },

    isLoggedIn() {
      return this.$store.getters.isLoggedIn;
    },

    // notification() {
    //   return this.$store.state.notification;
    // }
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
      ratingService.createOrUpdateRating(ratingData.landmarkId, ratingData.isGood)
        .then(response => {
          console.log('Rating successfully created:', response.data);
          this.retrieveCard();
        })
        .catch(error => {
          console.error('Error creating rating:', error);
        });
    },

    handleUpdateRating(rating) {
      ratingService.updateRating(rating.id, rating.isGood)
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
    },

    retrievePhoto(photoRef) {

      const baseURL = 'https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photo_reference=';

      const apiKey = '&key=AIzaSyBqJyZCzD-m22Izo98cXLx_PcND6cHoKWI';

      return (baseURL + photoRef + apiKey);

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
    },

    addToItinerary() {
      if (!this.validateForm) {
        return;
      }
      const landmarkId = this.$route.params.id;
      itineraryService.addLandmarkToItinerary(landmarkId, this.editItinerary).then(response => {
        if (response.status < 300 && response.status > 199) {
          this.$store.commit(
            'SET_NOTIFICATION',
            {
              message: 'A new stop was added to your itinerary.',
              type: 'success'
            }
          );
        }
      }).catch(error => {
        if (error.response) {
          this.$store.commit('SET_NOTIFICATION',
            "Error updating itinerary. Response received was ''" + error.response.statusText + "'.");
        } else if (error.request) {
          this.$store.commit('SET_NOTIFICATION', "Error updating itinerary. Server could not be reached.");
        } else {
          this.$store.commit('SET_NOTIFICATION', "Error updating itinerary. Request could not be created.");
        }

      });
      this.toggleDropdown();
    },

    validateForm() {
      let msg = '';
      if (this.editItinerary.itineraryId.length === 0) {
        msg += 'You must select an itinerary to add the landmark to.';
      }
      if (msg.length > 0) {
        this.$store.commit('SET_NOTIFICATION', msg);
        return false;
      }
      return true;
    },

  },

  created() {
    this.retrieveCard();
    this.retrieveDesignations();
    this.retrievePlacesAPIData();
    this.retrieveUserItineraries();
  },
};
</script>

<styles scoped>


</styles>


