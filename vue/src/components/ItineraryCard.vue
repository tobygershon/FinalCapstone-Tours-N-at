<template>

    <div>
        {{ this.itinerary.itineraryName }} <br>
        {{ this.itinerary.tourDate }}   <br>
    </div>
</template>


<script>

export default {

    props: ['itinerary']

}
</script>

