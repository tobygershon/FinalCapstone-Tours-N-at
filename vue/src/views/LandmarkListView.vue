<!-- search landmarks: list of the searched landmarks with clickable names to take to landmark cards -->

<template>
      <div id="searchBox">
    
    <Search />
  </div>
    
</template>


<script>
import Search from '../components/Search.vue';

export default {

    components: {
        Search,
    }
}

</script>../services/LandmarkService

<style>

#searchBox {
  display: flex;
  flex-direction: column;
  align-items: center;
}

</style>