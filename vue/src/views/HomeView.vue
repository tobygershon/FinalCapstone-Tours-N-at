<template>
  <div class="home">
    

  </div>   
   
  <!-- add nav bar: login logout itineraries 
    want to add map and search components -->
  <Search />
  <!-- <img id="tour-logo" src="./assets/Tours_Nat.png" alt=""> -->
</template>

<script>
import Search from '../components/Search.vue';

export default {

  components: {
    Search,
  },

};
</script>

<style>
#tour-logo {
  height: 100px;
}

</style>
