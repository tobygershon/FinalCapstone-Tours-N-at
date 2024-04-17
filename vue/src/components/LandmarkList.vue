<!-- List of landmarks can click for cards -->

<template>
    <div id="list">
        <div class="landmarkList">

            <router-link :to="{ name: 'landmarkDetailsView', params: { id: landmark.landmarkId } }" v-for="landmark in landmarks"
                :key="landmark.landmarkId">
                <div class="cardsList">
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

<style scoped>


</style>
