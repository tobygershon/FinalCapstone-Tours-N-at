<!-- individual card rep landmark with all data -->

<template>
    <div>
        {{ this.landmark.landmarkName }} <br>
        {{ this.landmark.address }}
    </div>
</template>


<script>

export default {

    props: ['landmark']

}


</script>


<style></style>