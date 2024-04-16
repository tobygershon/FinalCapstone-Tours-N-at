<template>
  <div id="capstone-app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">Login</router-link>
      <router-link :to="{ name: 'landmarkList'}">Search Landmarks</router-link>&nbsp;
      <span v-if="$store.state.token != ''">
        |&nbsp;<router-link v-bind:to="{ name: 'logout' }">Logout</router-link>
        &nbsp;|&nbsp;<router-link v-bind:to="{ name: 'itineraryList' }">My
          Itineraries</router-link>
        &nbsp;|&nbsp;<router-link :to="{ name: 'userRating' }" v-if="$store.state.token != ''">My Ratings</router-link>
      </span>
    </div>
    <div id="main">
      <router-view />
    </div>
  </div>
</template>



