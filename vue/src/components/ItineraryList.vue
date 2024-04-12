<template>
    <div id="itinerary-list">
        <h2>Your Itineraries</h2>
        <div class="itineraryList">

            <router-link :to="{ name: 'itineraryDetail', params: { itineraryId: itinerary.itineraryId } }"
                v-for="itinerary in itineraries" :key="itinerary.itineraryId">
                <div class="itineraryCardList">
                    <ItineraryCard :itinerary="itinerary" />
                </div>
            </router-link>

        </div>
    </div>
</template>

<script>
import ItineraryCard from "./ItineraryCard.vue";


export default {

    props: ['itineraries'],

    components: {
        ItineraryCard
    }
}

</script>

<style>
.itineraryList {
    width: 100%;
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    text-justify: center;
}

.itineraryCardList {
    margin: 10px 20px 10px 10px;
    padding: 10px 20px;
    background-color: #FBE134;
    text-align: center;
    border: solid 2px black;
    width: 20rem;
    height: 10rem;
    border-radius: 0.5rem;
    flex: 1;
}

.itineraryCardList:hover {
    cursor: pointer;
}
</style>