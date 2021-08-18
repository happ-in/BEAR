<template>
  <!-- <div id="nav">
    <router-link to="/">Home</router-link> |
    <router-link to="/ar">AR</router-link> |
    <router-link to="/recomendation">Rcomendation</router-link> |
    <router-link to="/search">Search</router-link> | -->
  <div id="app">
    <router-view></router-view>

    <tab-bar></tab-bar>
  </div>
</template>

<script>
import TabBar from "./components/TheTabBar.vue";
export default {
  name: "app",
  components: {
    "tab-bar": TabBar,
  },
};
</script>

<style>
@import url(//fonts.googleapis.com/earlyaccess/notosanskr.css);
@font-face {
  font-family: "Pretendard-Regular";
  src: url("https://cdn.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff") format("woff");
  font-weight: 400;
  font-style: normal;
}

.notosanskr * {
  font-family: "Noto Sans KR", sans-serif;
}

/* * {
  font-family: CookieRun-Regular;
} */
.header {
  width: 100%;
  height: 5vh;
  font-family: Pretendard-Regular;
  font-size: x-large;
  text-align: center;
  text-shadow: -1px 0 0 black;
}
.strong {
  font-weight: bold;
}
</style>
