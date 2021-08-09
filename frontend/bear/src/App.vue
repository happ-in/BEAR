<template>
  <div id="app">
    <router-view/> 
    <tab-bar></tab-bar>
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
