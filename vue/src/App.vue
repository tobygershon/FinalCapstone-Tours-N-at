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
</template>

<style>
#capstone-app, #main {
  background-color: #E9EAEC;
  height: 100%;
  width: 100%;
  margin: 10px;
  padding: 10px;
  border-radius: 10px;
}
</style>

