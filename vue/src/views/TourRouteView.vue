<!-- come here when tour route for an itinerary is generated: displays maps and written directions component -->

<template>
  <div id="directionsStep" v-for="(route, index) in routes" :key="index">
    <div v-if="!isCollapsed.includes(index)" class="directionStepDiv">
      <Map :thisRoute="route"></Map>
      <TourDirections @collapse="collapse" :thisRoute="route" :index="index" />
    </div>
    <div v-else class="directionStepDiv" id="collapsedDiv">
      <span>Step {{ index + 1 }}</span><span id="expandBTN" @click="expand(index)">+ EXPAND</span>
    </div>
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
      this.isCollapsed.push(index);
    },

    expand(index) {
      const removed = this.isCollapsed.filter(num => num != index);
      this.isCollapsed = removed;
    }

  },

  created() {
    this.getRoutes();
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
</style>