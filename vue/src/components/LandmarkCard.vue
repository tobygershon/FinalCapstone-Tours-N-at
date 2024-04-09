<!-- individual card rep landmark with all data -->

<template>
    <div class="landmark">
        <h2>{{ cardLandmark.name }}</h2>
        <img class="landmarkImage" src="" alt="Landmark Image">
        <span>Link to Landmark's Website <a href=""></a></span>

        <div>
            <!-- need rating component here -->
        </div>
    </div>
</template>


<script>

export default {
    props: ['cardLandmark']
}

</script>


<style>

</style>