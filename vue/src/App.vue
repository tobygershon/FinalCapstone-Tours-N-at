<template>
  <div id="capstone-app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">Login</router-link>
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      &nbsp;|&nbsp;<router-link v-bind:to="{ name: 'itineraryList' }" v-if="$store.state.token != ''">My Itineraries</router-link>
    </div>
    <div id="main">
      <router-view />
    </div>
  </div>
</template>


<style>
#capstone-app {
  width: 100%;
  height: 100ch;
  padding: 20px;
  margin: 10px;
  border-radius: 5px;
  background-color: #E9EAEC;
}
</style>

