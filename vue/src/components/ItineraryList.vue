<template>
    <div id="itinerary-list">
        <div class="itineraryList">

            <router-link :to="{ name: 'itineraryDetail', params: { itineraryId: itinerary.itineraryId } }"
                v-for="itinerary in itineraries" :key="itinerary.itineraryId">
                <div class="cardsList">
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
