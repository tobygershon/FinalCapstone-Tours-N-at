<!-- Written directions generated when user creates a route from itinerary -->

<template>
    <div id="directionsBox">
        <div v-for="(step, index) in steps" :key="index" id="directionStep">
            <div id="step">
                Step {{ index + 1 }}:
            </div>
            <span v-html="step.html_instructions"></span>
        </div>
    </div>
</template>

<script>

export default {
    props: ['thisRoute'],

    computed: {

        steps() {
            return this.thisRoute.legs[0].steps;
        }
    }
}


</script>

<style scoped>
#directionsBox {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    margin: 35px 10px 0 5px;
}

#directionStep {
    display: flex;
}

#step {
    display: inline;
    font-weight: 800;
    margin-right: 10px;
}


</style>