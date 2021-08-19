<template>
  <div id="tab-wrap">
    <!-- AR button -->
    <div class="ar_button">
      <button @click="ar_path">
        <img src="../assets/tabBar/ar.png" alt="ar_icon" width="40" />
      </button>
    </div>
    <!-- tabbar -->
    <div class="tabbar">
      <div id="menu">
        <router-link v-for="route in routes" :key="route.key" :to="route.path" class="tabbar-menu-list" class-activate="active" exact>
          <img width="30" :src="route.img" alt="" />
          <div>{{ route.title }}</div>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "TabBar",
  components: {},
  data() {
    return {
      routes: [
        { path: "/recommendation", title: "랜덤추천", img: require("../assets/tabBar/dice.png") },
        { path: "/ranking", title: "랭킹", img: require("../assets/tabBar/rank.png") },
        { path: "/feed", title: "홈피드", img: require("../assets/tabBar/house.png") },
        { path: "/search", title: "검색", img: require("../assets/tabBar/search.png") },
        { path: "/myprofile", title: "마이페이지", img: require("../assets/tabBar/profile.png") },
      ],
      ar_link: { path: "/ar", title: "AR", img: require("../assets/tabBar/ar.png") },
    };
  },
  methods: {
    ar_path: function () {
      window.location.href = "/ar";
    },
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap");

.ar_button {
  position: fixed;
  float: right;
  bottom: 0;
  height: 40vw;
  right: 4%;
  z-index: 7;
}
.ar_button button {
  border-radius: 50%;
  height: 60px;
  width: 60px;
  padding: 0;
  border: 0;

  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  background-color: #f5df4d;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
}
.tabbar {
  position: fixed;
  left: 0;
  bottom: 0;
  width: 100%;
  height: 17vw;
  padding-top: 2%;
  display: flex;
  justify-content: space-around;
  background-color: white;
  box-shadow: 0px -1px rgb(192, 184, 184);
  z-index: 8;
}
#menu {
  padding: 0;
  display: flex;
  text-align: center;

  font-family: "Noto Sans KR", sans-serif;
}
.tabbar-menu-list {
  padding: 0 5vw;
  text-decoration: none;
  font-size: 10px;
  color: black;
}
</style>
