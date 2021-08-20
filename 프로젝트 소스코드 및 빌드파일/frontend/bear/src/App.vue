<template>
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
.header {
  width: 100%;
  height: 5vh;
  font-family: Pretendard-Regular;
  font-size: x-large;
  text-align: center;
  text-shadow: -1px 0 0 black;
  margin-bottom: 2%;
}
.strong {
  font-weight: bold;
}
.profile-follow-box {
  height: 9vh;
  border-bottom: 1px solid grey;
  border-top: 1px solid gray;
  align-content: center;
}
.profile-nickname {
  text-align: left;
  font-size: x-large;
  font-weight: bold;
  padding-bottom: 3%;
}
</style>
