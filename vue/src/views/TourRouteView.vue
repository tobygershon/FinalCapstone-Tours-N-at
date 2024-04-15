<!-- come here when tour route for an itinerary is generated: displays maps and written directions component -->

<template>
  <div id="directionsStep" v-for="(route, index) in routes" :key="index" >
    <Map :thisRoute="route"></Map>
    <TourDirections v-if="!isCollapsed.includes(index)" @collapse="collapse" :thisRoute="route" :index="index"/>
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
      isCollapsed: []
    }
  },


  methods: {
    getRoutes() {
      DirectionsService.getDirections(this.$route.params.itineraryId).then(response => {
        this.routes = response.data.routes;
      })
    },

    collapse(index) {

    }

  },

  created() {
    this.getRoutes();
  }

}


</script>

<style scoped>

#directionsStep {
  display: flex;
  justify-content: space-around;
  margin: 20px 0;
  padding: 0 0 10px 0;
  border: solid rgb(42, 46, 52) 5px;
  border-radius: 10px;
  background-color: rgb(251, 225, 52, .9);
  width: 90vw;
}

</style>