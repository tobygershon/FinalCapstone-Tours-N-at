<!-- search landmarks: list of the searched landmarks with clickable names to take to landmark cards -->

<template>
    <Search />
    <!-- <LandmarkList :landmarks="landmarks"/> -->
    
</template>


<script>
// import LandmarkList from '../components/LandmarkList.vue';
import landmarkService from '../services/LandmarkService.js';
import Search from '../components/Search.vue';

export default {

    components: {
        // LandmarkList,
        Search,
    },

    data() {
        return {
            landmarks: [],
        }
    },

    methods: {

        testSearchAll() {
            landmarkService.getAllLandmarks().then(response => {
                this.landmarks = response.data;
            })
        },

        retrieveSearchResults() {
            if (this.designation === '') {
                landmarkService.getAllLandmarks().then(response => {
                    this.landmarks = response.data;
                })
            } else {
                landmarkService.getLandmarksByDesignation(this.designation).then(response => {
                    this.landmarks = response.data;
                })
            }
        }
    },

    created() {
        this.testSearchAll();
        // this.retrieveSearchResults();
    }
}

</script>../services/LandmarkService