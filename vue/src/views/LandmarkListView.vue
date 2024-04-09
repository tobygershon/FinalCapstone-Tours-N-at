<!-- search landmarks: list of the searched landmarks with clickable names to take to landmark cards -->

<template>
    <LandmarkList :landmarks="landmarks"/>
</template>


<script>
import LandmarkList from '../components/LandmarkList.vue';
import SearchService from '../services/SearchService';

export default {

    props: ['designation'],
    // designation brought in as prop?  or in data?

    components: {
        LandmarkList
    },

    data() {
        return {
            landmarks: []
        }
    },

    methods: {

        testSearchAll() {
            SearchService.getAllLandmarks().then(response => {
                this.landmarks = response.data;
            })
        },

        retrieveSearchResults() {
            if (this.designation === '') {
                SearchService.getAllLandmarks().then(response => {
                    this.landmarks = response.data;
                })
            } else {
                SearchService.getLandmarksByDesignation(this.designation).then(response => {
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

</script>