<template>
    <div id="itinerary-list">
        <h2>Your Itineraries</h2>
        <div class="itineraryList">

            <router-link :to="{ name: 'itineraryDetail', params: { itineraryId: itinerary.itineraryId } }"
                v-for="itinerary in itineraries" :key="itinerary.itineraryId">
                <div class="cardList">
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
