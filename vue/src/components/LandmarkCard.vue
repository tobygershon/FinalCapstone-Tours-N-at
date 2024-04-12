<!-- individual card rep landmark with all data -->

<template>
    <div>
        <p>{{ landmark.landmarkName }}</p>
    </div>
</template>


<script>
import landmarkService from '../services/LandmarkService';

export default {

    props: ['landmark'],

    data() {
        return {

        }
    },



}


</script>


