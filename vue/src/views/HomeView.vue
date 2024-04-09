<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
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
}

};
</script>
