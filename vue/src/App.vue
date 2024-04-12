<template>
  <div id="capstone-app">
    <div id="nav">
      <router-link class="header-fonts" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link class="header-fonts" v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''">Login</router-link>
      <router-link class="header-fonts" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <div id="main">
      <router-view />
    </div>
  </div>
</template>



