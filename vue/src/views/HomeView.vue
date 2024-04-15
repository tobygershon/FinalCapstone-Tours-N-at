<template>
  <div class="home">


  </div>

  <!-- add nav bar: login logout itineraries 
    want to add map and search components -->
  <div id="searchBox">
    <img id="tour-logo" src="./assets/Tours_Nat.png" alt="">
    <Search />
  </div>
 
</template>

<script>
import Search from '../components/Search.vue';


export default {

  components: {
    Search
  },

};
</script>

<style>
#tour-logo {
  height: 75px;
}

#searchBox {
  position: relative;
  top: -85px;
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>
