<!-- List of landmarks can click for cards -->

<template>
    <div>
        <h2>Search Results</h2>
        <div class="landmarkList">
        <div v-for="landmark in landmarks" :key="landmark.landmarkId" class="landmarkCardsList">
                {{landmark.landmarkName}} <br>
                {{ landmark.address }}
                <router-link to="{ name : 'landmarkCard' , params: {id: landmarkId}}">
                click here
            </router-link>
        </div>

    </div>
    </div>
</template>

<script>
// import LandmarkCard from "../components/LandmarkCard.vue";


export default {

    props: ['landmarks'],
    
    components: {
   
}
}

</script>

<style>

.landmarkCardsList {
margin: 10px;
padding: 10px 20px;
background-color: #FBE134;
text-align: center;
border: solid 2px black;
width: 400px;
height: 100px;
}

.landmarkCardsList:hover {
    cursor: pointer;
}

.landmarkList {
    display: flex;
    flex-direction: column;
    align-items: center;
}

</style>