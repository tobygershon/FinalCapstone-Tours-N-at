<!-- Written directions generated when user creates a route from itinerary -->

<template>
    <div id="directionsBox">
        <div id="collapseBTN">
            <button>- COLLAPSE</button>
        </div>
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

    data() {
        return {
            stepIsShowing: true
        }
    },

    computed: {

        steps() {
            return this.thisRoute.legs[0].steps;
        }
    }
}


</script>

<style scoped>

#collapseBTN {
    padding-right: 5px;
    display: flex;
    align-items: center;
    justify-content: flex-end;
    height: 35px;
    font-size: 1.25rem;
    font-weight: 900;

}
#directionsBox {
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    margin: 0 10px 0 5px;
}

#directionStep {
    display: flex;
    margin-bottom: 5px;
}

#step {
    display: inline;
    font-weight: 800;
    margin-right: 10px;
}
</style>