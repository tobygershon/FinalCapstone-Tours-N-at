<template>
  <div id="container">
  <div id="capstone-app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
  </div>
</template>

<style>
#container {
  width: 100%;
  height: 100vh;
  background-color: #E9EAEC;
}
</style>

