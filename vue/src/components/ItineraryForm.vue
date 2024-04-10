<!-- form to create a new itinerary: need name, date, and starting point min -->
<template>
    <div>
        <label for="itineraryName">Name Your Itinerary:</label>
        <input type="text" name="itineraryName" id="itineraryNameText" placeholder="Itinerary Name" v-model="itineraryName">
    </div>
    <div>
        <label for="startingPoint">Choose Your Starting Location:</label>
        <input type="text" name="startingPoint" id="startingPointText" placeholder="Starting Location" v-model="startingLocationId">
    </div>
    <div>
        <label for="dateSelector">Select a Tour Date:</label>
        <input type="date" id="dateSelector" v-model="selectedDate" :min="getCurrentDate">
    </div>
</template>
  
<script>
export default {
    data() {
        return {
            editItinerary: {
                id: '',
                itineraryName: '',
                startingLocationId: '',
                selectedDate: '',
            }
        }
    }
}
</script>
