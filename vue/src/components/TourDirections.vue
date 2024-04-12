<!-- Written directions generated when user creates a route from itinerary -->

<template>
        <div v-for="(step, index) in steps" :key="index">
            step {{ index + 1 }}:
            <span v-html="step.html_instructions"></span>
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