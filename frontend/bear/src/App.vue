<template>
<<<<<<< HEAD
  <div id="nav">
    <router-link to="/">Home</router-link> |
    <router-link to="/ar">AR</router-link> |
    <router-link to="/recomendation">Rcomendation</router-link> |
    <router-link to="/search">Search</router-link> |
=======
  <div id="app">
    <router-view></router-view> 
    
    <tab-bar></tab-bar>
>>>>>>> 29fde58f8c8888a2f72db1133b9d3bf03e78e72b
  </div>
</template>

<script>
import TabBar from './components/TheTabBar.vue'
export default {
  name: 'app',
  components: {
    'tab-bar': TabBar,
  }
}
</script>

<style>


</style>
