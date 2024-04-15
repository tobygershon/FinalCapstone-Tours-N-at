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
    background-color: rgba(251, 225, 52, 0.7);
    border: solid 2px black;
    border-radius: 0.5rem;
    font-weight: 500px;
    margin: 20px auto;
    padding: 20px;
    text-align: center;
    width: auto;
}
</style>