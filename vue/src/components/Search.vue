<!-- search component for searching landmarks. Want filtering ability for types of attractions? -->
<template>
    <div id="searchBars">
        <div id="searchInput">
            <span>Search Points of Interest by Name:&nbsp;</span>
            <input v-model="searchTerm" placeholder="Enter landmark name" />
            <input type="button" @click="searchByName" value="Go!">
            <div v-if="message" class="alert-message">
                {{ message }}
            </div>
        </div>

        <img id="tour-logo" src="../assets/Tours_Nat.png" alt="">

        <div id="searchDropDown">
            <label for="points-of-interest-category-dropdown">Search Points of Interest by Category:&nbsp;</label>
            <select v-model="designationSelection" id="category-dropdown" name="categoryDropdown">
                <option value=""> </option>
                <option value="Search All">Search All</option>
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
        </div>
    </div>
    <LandmarkList :landmarks="landmarks" />
</template>

<script>
import landmarkService from '../services/LandmarkService.js';
import LandmarkList from '../components/LandmarkList.vue';


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
        LandmarkList
    },

    methods: {
        retrieveLandmarks() {
            // set the interest text
            this.$store.commit('SET_INTEREST_SEARCH',this.designationSelection);
            if (this.designationSelection === '' || this.designationSelection === 'Search All') {
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

    },

    created() {
        // look to see if there is a interestSearch in store, 
        // if so, load up
        if(this.$store.state.interestSearch) {
            this.designationSelection = this.$store.state.interestSearch;
            this.retrieveLandmarks();
        }
    }
}

</script>../services/LandmarkService.js

<style scoped>
#searchBars {
    font-weight: 700;
    display: flex;
    justify-content: space-between;
    background-color: #2A2E34;
    padding: 0 10px;
    border-radius: 20px;
    border: 2px solid #FBE134;
    width: 85vw;
    color: #FBE134;
    position: relative;
    top: -5px;
    margin-bottom: 5px;
}

#searchDropDown,
#searchInput {
    display: flex;
    align-items: center;
}

#tour-logo {
    height: 85px;
    padding: 0;
    margin: 1px 10px;
}
</style>