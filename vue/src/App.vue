<template>
  <div id="capstone-app">
    <div id="nav">
      <router-link :to="{ name: 'home' }">Home</router-link>
      <router-link v-if="$store.state.token != ''" :to="{ name: 'logout' }">Logout</router-link>
    </div>
    <div id="main">
      <router-view />
    </div>
  </div>
</template>


<style>
#capstone-app {
  width: 100%;
  height: 100vh;
  padding: 20px;
  margin: 10px;
  border-radius: 5px;
  background-color: #E9EAEC;
}
</style>

