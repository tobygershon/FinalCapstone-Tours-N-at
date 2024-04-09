<!-- List of landmarks can click for cards -->

<template>
    <div>
        <h2>Search Results</h2>
        <div v-for="landmark in landmarks" :key="landmark.id" class="landmarkCardsList">
                <LandmarkCard :landmark="cardLandmark"/>
                <!-- <router-link 
                :to="{name: 'landmarkCard', params: { id: landmark.id} }">
            
            </router-link> -->
        </div>
    </div>
</template>

<script>
import LandmarkCard from "../components/LandmarkCard.vue";


export default {

    props: ['landmarks'],
    
    components: {
    LandmarkCard,
}
}



</script>