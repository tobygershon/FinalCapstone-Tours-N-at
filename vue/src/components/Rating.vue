<template>
    <div class="rating-container">
        <router-link :to="{ name: 'landmarkDetailsView', params: { id: rating.landmarkId } }"> {{ rating.landmarkName }}
        </router-link>
        <div v-if="rating.isGood"><i class="fas fa-thumbs-up"></i></div>
        <div v-else><i class="fas fa-thumbs-down"></i></div>
    </div>
</template>

<script>

export default {
    props: ['rating']
}

</script>

<style scoped>
.rating-container {
    align-items: center;
    margin: 20px auto;
    padding: 20px;
    background-color: rgba(251, 225, 52, 0.7);
    text-align: center;
    border: solid 2px black;
    width: auto;
    font-weight: 500px;
}
</style>