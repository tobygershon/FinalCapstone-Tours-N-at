<template>
  <div class="home">
    <h1>Tours N'at!</h1>
    <button v-show="$store.state.token != ''" @click="goToItineraryView">My Itineraries</button>
  </div>
  <!-- add nav bar: login logout itineraries 
    want to add map and search components -->
  <Search />
</template>

<script>
import Search from '../components/Search.vue';

export default {

  components: {
    Search
  },

  methods: {
    goToItineraryView() {
      this.$router.push({name: 'itineraryList', params: {userId: 1}})
    }
  }

};
</script>
