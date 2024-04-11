<!-- search component for searching landmarks. Want filtering ability for types of attractions? -->
<template>
    <div>
        <span>Search landmark by its name:</span>
        <input v-model="searchTerm" placeholder="Enter landmark name" />
        <button @click="searchByName">Search</button>
        <div v-if="message" class="alert-message">
            {{ message }}
        </div>
    </div>

    <label for="points-of-interest-category-dropdown">Search Points of Interest:</label>
    <select v-model="designationSelection" id="category-dropdown" name="categoryDropdown">
        <option value=""> </option>
        <option value="Attraction">Attractions</option>
        <option value="Food">Food</option>
        <option value="Historic Site">Historic Sites</option>
        <option value="Kid-Friendly">Kid-Friendly</option>
        <option value="Museum">Museum</option>
        <option value="Park">Park</option>
        <option value="Scenic Viewpoint">Scenic Viewpoint</option>
        <option value="Sporting Venue">Sporting Venue</option>
    </select>
    <input type="button" @click="retrieveLandmarks" value="Go!">
    <LandmarkList :landmarks="landmarks" />
</template>

<script>
import landmarkService from '../services/LandmarkService.js';
import LandmarkList from './LandmarkList.vue';

export default {

    data() {
        return {
            landmarks: [],
            designationSelection: '',
            searchTerm: '',
            message: '',
        }
    },

    components: {
        LandmarkList,
    },

    methods: {
        retrieveLandmarks() {
            if (this.designationSelection === '') {
                landmarkService.getAllLandmarks().then(response => {
                    this.landmarks = response.data;
                }).catch(error => {
                    if (error.response) {
                        this.$store.commit('SET_NOTIFICATION',
                            "Error getting points of interest. Response received was ''" + error.response.statusText + "'.");
                    } else if (error.request) {
                        this.$store.commit('SET_NOTIFICATION', "Error getting points of interest. Server could not be reached.");
                    } else {
                        this.$store.commit('SET_NOTIFICATION', "Error getting points of interest. Request could not be created.");
                    }
                });
            } else {
                landmarkService.getLandmarksByDesignation(this.designationSelection).then(response => {
                    this.landmarks = response.data;
                }).catch(error => {
                    if (error.response) {
                        this.$store.commit('SET_NOTIFICATION',
                            "Error getting points of interest. Response received was ''" + error.response.statusText + "'.");
                    } else if (error.request) {
                        this.$store.commit('SET_NOTIFICATION', "Error getting points of interest. Server could not be reached.");
                    } else {
                        this.$store.commit('SET_NOTIFICATION', "Error getting points of interest. Request could not be created.");
                    }
                });
            }
        },

        searchByName() {
            this.message = '';
            if (this.searchTerm.trim() === '') {
                this.message = "Please enter a landmark name into the search box to start your search.";
            } else {
                landmarkService.getLandmarksByName(this.searchTerm).then(response => {
                    if (response.data.length === 0) {
                        this.message = `No results found for "${this.searchTerm}". Try checking your spelling or using different keywords.`;
                    } else {
                        this.landmarks = response.data;
                    }
                }).catch(error => {
                    console.error('Error searching landmarks by name:', error);
                    this.message = "We encountered an error while processing your search. Please try again later.";
                    this.$store.commit('SET_NOTIFICATION', "Error searching landmarks by name.");
                });
            }
        },

    }
}

</script>../services/LandmarkService.js