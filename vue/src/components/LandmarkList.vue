<!-- List of landmarks can click for cards -->

<template>
    <div>
        <h2>Search Results</h2>
        <div class="landmarkList">
            <div v-for="landmark in landmarks" :key="landmark.landmarkId" class="landmarkCardsList">
                <router-link :to="{ name: 'landmarkCard', params: { id: landmark.landmarkId } }">
                    <LandmarkCard :landmark="landmark" />
                </router-link>
            </div>

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
.landmarkCardsList {
    margin: 10px;
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
    display: flex;
    flex-direction: column;
    align-items: center;
}
</style>