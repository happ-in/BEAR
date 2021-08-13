<template>
  <div id="tab-wrap">
    <!-- AR button -->
    <div class="ar_button">
      <button @click="ar_path">
        <!-- 카메라 아이콘 (넣어야함) -->
        <p>AR</p>
      </button>
    </div>
    <!-- tabbar -->
    <div class="tabbar">
      <ul id="menu">
        <router-link
          v-for="route in routes"
          :key="route.key"
          :to="route.path"
          tag="li"
          class="tabbar-menu-list"
          class-activate="active"
          exact
          >{{ route.title }}
        </router-link>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: "TabBar",
  components: {},
  data() {
    //html과 자바스크립트 코드에서 사용할 데이터 변수 선언
    return {
      routes: [
        { path: "/recommendation", title: "랜덤 추천" },
        { path: "/ranking", title: "랭킹" },
        { path: "/", title: "홈피드" },
        { path: "/search", title: "검색" },
        { path: "/myprofile", title: "마이페이지" },
      ],
      ar_link: { path: "/ar", title: "AR" },
    };
  },
  setup() {}, //컴포지션 API
  created() {}, //컴포넌트가 생성되면 실행
  mounted() {}, //template에 정의된 html코드가 레너링된 후 실행
  unmounted() {}, //unmount가 완료된 후 실행
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
  /* border: 0; */
  bottom: 0;
  /* width: 100%; */
  height: 30vw;
  right: 4%;
}
.ar_button button {
  border-radius: 50%;
  height: 50px;
  width: 50px;
  padding: 0;
  border: 0;

  display: flex;
  justify-content: center;
  align-items: center;

  background: #f5df4d;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
}
.ar_button button p {
}
.tabbar {
  position: fixed;
  left: 0;
  bottom: 0;
  width: 100%;
  height: 10vw;

  display: flex;
  justify-content: space-around;
}
#menu {
  padding: 0;
  /* text-align: center; */

  font-family: "Noto Sans KR", sans-serif;
  /* text-decoration: none; */
}
.tabbar-menu-list {
  padding: 0 3vw;
}
</style>
