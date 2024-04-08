<!-- List of landmarks can click for cards -->

<template>
    <div>
        <h2>Search Results</h2>
        <div class="landmarkCardsList">
            <router-link v-for="landmark in landmarks" :key="landmark.id" 
                :to="{name: 'landmarkCard', params: { id: landmark.id} }">
                <LandmarkCard />
            </router-link>
        </div>
    </div>
</template>

<script>
import LandmarkCard from "../components/LandmarkCard.vue";

export default {

    props: ['landmarks'],
    
    components: {
        LandmarkCard
    },
}



</script>