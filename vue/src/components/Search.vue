<!-- search component for searching landmarks. Want filtering ability for types of attractions? -->
<template>
    <label for="points-of-interest-category-dropdown">Search Points of Interest:</label>
    <select v-model="designationSelection" id="category-dropdown" name="categoryDropdown">
        <option value=""> </option>
        <option value="Attractions">Attractions</option>
        <option value="Food">Food</option>
        <option value="Historic Sites">Historic Sites</option>
        <option value="Kid-Friendly">Kid-Friendly</option>
        <option value="Museum">Museum</option>
        <option value="Park">Park</option>
        <option value="Scenic Viewpoint">Scenic Viewpoint</option>
        <option value="Sporting Venue">Sporting Venue</option>
    </select>
    <input type="submit" @click="retrieveLandmarks" value="Go!">
</template>

<script>
import searchService from '../services/SearchService';
export default {

    data() {
        return {
            landmarks: [],
            designationSelection: '',
        }
    },

    methods: {
        retrieveLandmarks() {
            if (this.designationSelection === '') {
                searchService.getAllLandmarks().then(response => {
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
            searchService.getLandmarksByDesignation(this.designationSelection).then(response => {
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

    }
}
}

</script>