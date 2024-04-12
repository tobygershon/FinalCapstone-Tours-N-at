<template>
    <div id="itinerary-card">
        <div>{{ this.itinerary.itineraryName }}</div>
        <div>{{ this.itinerary.tourDate }}</div>
        <div>Starting From: {{ this.itinerary.startingLocationName }}</div>
    </div>
</template>


<script>

export default {

    props: ['itinerary']

}
</script>

<style>
#itinerary-card {
    display: flex;
    flex-direction: column;
}
