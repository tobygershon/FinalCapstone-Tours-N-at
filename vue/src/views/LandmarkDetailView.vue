<template>
    <div>
      <h2>{{ landmark.landmarkName }}</h2>
      <p>Address: {{ landmark.address }}</p>
      <p>Description: {{ landmark.description }}</p>
      <p>Designation:
          {{ designation }}
      </p>
      <p>Hours: {{ landmark.hours }}</p> 
      <p>Ratings: {{ landmark.ratings }}</p>
      <button>Add to Itinerary</button><br>
      <button>Rate Up</button><br>
      <button>Rate Down</button><br>
      <router-link to="/landmarks">Back</router-link>
    </div>
  </template>
  
  <script>
  import landmarkService from '../services/LandmarkService';
  
  export default {
    data() {
      return {
        landmark: {

        },
        designations: {

        }
      };
    },
  
    methods: {
      retrieveCard() {
        const id = this.$route.params.id;
        landmarkService.getLandmarkById(id).then((response) => {
          this.landmark = response.data;
        });
      },
    },
  
    created() {
      this.retrieveCard();
    },
  };
  </script>