<template>
  <div id="home">

    <div id="logo-div">
      <img id="tour-logo" src="../assets/Tours_Nat.png" alt="">
    </div>

    <div id="about">

      <h1>Welcome to Tours N'at</h1>
      <h6>Welcome to the burgh! <br> First, yinz need to learn a little Pittsburgh'ese.
        N'at is slang for 'and that', and is often tacked on at the end of sentences.</h6>
      <h3>Search Pittsburgh Landmarks and Create Daily Itineraries to Explore the Sites!</h3>
      <p>Tours N'at lets you explore tourist attractions, museums, landmarks, restuarants
        and more throughout the city. Login to build daily itineraries and get directions.</p>

    </div>
  </div>

  <div id="curated">
    <h2>Curated Tours</h2>
    <div id="curatedTours">
      <div class="cardsList">"Dantan" (aka: Downtown) Pittsburgh</div>
      <div class="cardsList">Steel City Historical Tour</div>
      <div class="cardsList">Off the Beaten Path</div>
      <div class="cardsList">Kid'sburgh</div>
    </div>
  </div>
</template>

<script>



export default {

  components: {

  },

};
</script>

<style scoped>
#home {
  font-weight: 700;
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: #2A2E34;
  border-radius: 20px;
  border: 2px solid #FBE134;
  width: 85vw;
  color: #FBE134;
  margin-bottom: 10px;
}

#about {
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  height: 250px;
  padding-bottom: 5px;
}

#logo-div {
  min-width: 250px;
}

#tour-logo {
  height: 250px;
  width: 250px;
}

h1 {
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  font-size: 3rem;
  font-weight: 800;
}

h3 {
  font-size: 1.25rem;
  font-weight: 600;
}

h6 {
  font-size: 1rem;
  font-style: italic;
}

p {
  font-size: .75rem;
  padding-bottom: 5px;
}

#curated {
  display: flex;
  flex-direction: column;
  max-width: 85vw;
}

#curatedTours {
  display: flex;
}

h2 {
  background-color: #FBE134;
  font-size: 1.5rem;
  font-weight: 700;
  width: 15rem;
  margin: 0 auto;
  text-align: center;
  border-radius: 5px;
  border: solid #2A2E34 2px;
}

.cardsList {

display: flex;
align-items: center;
justify-content: center;
font-weight: 700;
font-size: 1.25rem;

}
</style>
