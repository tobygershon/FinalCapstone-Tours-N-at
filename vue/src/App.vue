<template>
  <div id="capstone-app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <div id="main">
      <router-view />
    </div>
  </div>
    <router-view />
</template>


<style>
#capstone-app, #main {
  width: 100%;
  height: 100vh;
  background-color: #E9EAEC;
}
</style>

