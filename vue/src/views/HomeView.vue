<template>
  <div id="home">

    <div id="logo-div">
      <img id="tour-logo" src="../assets/Tours_Nat.png" alt="">
    </div>

    <div id="about">
  
      <h1 class="permanent-marker-regular">Tours N'at</h1>

      <h3>Search Pittsburgh landmarks and create daily itineraries to explore the sites!</h3>

      <h6>Welcome to the burgh! <br> First, yinz need to learn a little Pittsburgh'ese.
        N'at is slang for 'and that', and is often tacked on at the end of sentences.</h6>
      
      <p>Tours N'at lets you explore tourist attractions, museums, landmarks, restuarants
        and more throughout the city. Login to build daily itineraries and get directions.</p>

    </div>
  </div>

  <div id="curated">
    <router-link :to="{name: 'landmarkList'}"><h2 class="link">Click Here to Search Landmarks</h2></router-link>
    <h2>See our Curated Tours Below!</h2>
    <div id="curatedTours">
      <div class="cardsList"><a href="http://127.0.0.1:5173/downtown">"Dahntahn" (aka: Downtown) Pittsburgh</a></div>
      <div class="cardsList"><a href="http://127.0.0.1:5173/steelcity">Steel City Historical Tour</a></div>
      <div class="cardsList"><a href="http://127.0.0.1:5173/offthebeatenpath">Off the Beaten Path</a></div>
      <div class="cardsList"><a href="http://127.0.0.1:5173/kidsburgh">Kid'sburgh</a></div>
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
  justify-content: space-around;
  align-items: center;
  background-color: #2A2E34;
  border-radius: 20px;
  border: 2px solid #FBE134;
  width: 85vw;
  min-height: 40vh;
  color: #FBE134;
  margin-bottom: 10px;
}

#about {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  min-height: 40vh;
  padding-bottom: 5px;
  margin: 0 5px 0 10px;
}

#logo-div {
  min-width: 250px;
}

#tour-logo {
  min-height: 225px;
  min-width: 225px;
  max-height: 35vh;
  max-width: 35vw;
}

h1 {
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  font-size: 3rem;
  font-weight: 800;
  margin-bottom: 3px;
}

h3 {
  font-size: 1.35rem;
  font-weight: 600;
  margin-bottom: 5px;
}

h6 {
  font-size: 1rem;
  font-style: italic;
  margin-bottom: 5px;
  margin-left: 10px;
}

p {
  font-weight: 400;
  font-size: .9rem;
  padding-bottom: 5px;
  padding-right: 5px;
  margin-bottom: 3px;
  margin-left: 20px;
}

#curated {
  margin-top: 30px;
  display: flex;
  flex-direction: column;
  max-width: 85vw;
}

#curatedTours {
  margin-top: 30px;
  display: flex;
  max-height: 35vh;
}

h2 {
  background-color: #FBE134;
  font-size: 1rem;
  font-weight: 700;
  width: 20rem;
  margin: 5px auto;
  text-align: center;
  border-radius: 20px;
  border: solid #2A2E34 2px;
}

.cardsList {
  display: flex;
  align-items: center;
  justify-content: center;
  font-weight: 700;
  font-size: 1.25rem;

}

#curated.a {
  text-decoration: none;
  color:#2A2E34;
}

.permanent-marker-regular {
  font-family: "Permanent Marker", cursive;
  font-weight: 100;
  font-style: normal;
}
</style>
