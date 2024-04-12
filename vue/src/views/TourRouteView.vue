<!-- come here when tour route for an itinerary is generated: displays maps and written directions component -->

<template>
  <div id="directionsStep" v-for="(route, index) in routes" :key="index">
    <Map :thisRoute="route"></Map>
    <TourDirections :thisRoute="route" />
  </div>
</template>

<script>
import Map from '../components/Map.vue';
import TourDirections from '../components/TourDirections.vue';
import DirectionsService from '../services/DirectionsService.js';

export default {

  components: {
    Map,
    TourDirections
  },

  data() {
    return {
      routes: [],
    }
  },


  methods: {
    getRoutes() {
      DirectionsService.getDirections(this.$route.params.itineraryId).then(response => {
        this.routes = response.data.routes;
      })
    }

  },

  created() {
    this.getRoutes();
  }

}


</script>