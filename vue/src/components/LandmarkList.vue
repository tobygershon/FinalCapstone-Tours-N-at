<!-- List of landmarks can click for cards -->

<template>
    <div id="list">
        <h2>Search Results</h2>
        <div class="landmarkList">
            
                <router-link :to="{ name: 'landmarkCard', params: { id: landmark.landmarkId }}" 
                                v-for="landmark in landmarks" :key="landmark.landmarkId">
                    <div class="landmarkCardsList">
                    <LandmarkCard :landmark="landmark" />
                    </div>
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
    }
}

</script>

<style>

#list {
    display: flex;
    flex-direction: column;
    align-items: center;
}
.landmarkCardsList {
    margin: 10px 20px 10px 10px;
    padding: 10px 20px;
    background-color: #FBE134;
    text-align: center;
    border: solid 2px black;
    width: 400px;
    height: 100px;
    border-radius: 5px;
}

.landmarkCardsList:hover {
    cursor: pointer;
}

.landmarkList {
    width: 800px;
    display: flex;
    /* flex-direction: column; */
    justify-content: space-around;
    flex-wrap: wrap;
}
</style>