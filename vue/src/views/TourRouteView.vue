<!-- come here when tour route for an itinerary is generated: displays maps and written directions component -->

<template>
  <div id="directionsStep" v-for="(route, index) in routes" :key="index">
    <div v-if="!isCollapsed.includes(index)" class="directionStepDiv">
      <Map :thisRoute="route" :url="urlList[index]"></Map>
      <TourDirections @collapse="collapse" :thisRoute="route" :index="index" />
    </div>
    <div v-else class="directionStepDiv" id="collapsedDiv">
      <span>Step {{ index + 1 }}</span><span id="expandBTN" @click="expand(index)">+ EXPAND</span>
    </div>
  </div>
  <router-link class="back-button" :to="{ name: 'itineraryDetail', params: { itineraryId :this.$route.params.itineraryId} }"><i class="fas fa-arrow-left">Back</i></router-link>

</template>

<script>
import Map from '../components/Map.vue';
import TourDirections from '../components/TourDirections.vue';
import DirectionsService from '../services/DirectionsService.js';
import ItineraryService from '../services/ItineraryService';

export default {

  components: {
    Map,
    TourDirections
  },

  data() {
    return {
      routes: [],
      isCollapsed: [],
      urlList: []
    }
  },


  methods: {
    getRoutes() {
      DirectionsService.getDirections(this.$route.params.itineraryId).then(response => {
        this.routes = response.data.routes;
      })
    },

    getURLs() {
      ItineraryService.getListOfPlaceUrlByItineraryId(this.$route.params.itineraryId).then(response => {
        this.urlList = response.data;
      })
    },

    collapse(index) {
      this.isCollapsed.push(index);
    },

    expand(index) {
      const removed = this.isCollapsed.filter(num => num != index);
      this.isCollapsed = removed;
    }

  },

  created() {
    this.getRoutes();
    this.getURLs();
  }

}


</script>

<style scoped>
.directionStepDiv {
  display: flex;
  justify-content: space-around;
  margin: 20px 0;
  padding: 0 0 10px 0;
  border: solid rgb(42, 46, 52) 5px;
  border-radius: 10px;
  background-color: rgb(251, 225, 52, .9);
  width: 90vw;
  padding-top: 7px;
}

#collapsedDiv {
    display: flex;
    align-items: center;
    justify-content: space-between;
    height: 35px;
    font-size: 1.25rem;
    font-weight: 700;
}

#expandBTN {
  cursor: pointer;
}

span {
  padding: 5px 20px 5px 10px;
}

.back-button {
  position: absolute; 
  top: 35px; 
  left: 45px; 
  padding: 5px 10px; 
  cursor: pointer; 
  text-decoration: none; 
  color: black; 
}
</style>