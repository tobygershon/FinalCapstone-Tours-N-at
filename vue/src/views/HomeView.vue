<template>
  <div class="home">


  </div>

  <!-- add nav bar: login logout itineraries 
    want to add map and search components -->
  <div id="searchBox">
    
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

#searchBox {
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>
