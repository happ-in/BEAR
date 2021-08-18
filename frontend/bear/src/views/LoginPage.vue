<template>
  <div id="container">
    <img id="login-logo" src="../assets/landing/logo1.png" />
    <a id="custom-login-btn" @click="kakaoLogin()">
      <img id="login-btn" src="//k.kakaocdn.net/14/dn/btqCn0WEmI3/nijroPfbpCa4at5EIsjyf0/o.jpg" width="380" />
    </a>
  </div>
</template>
<script>
// import axios from 'axios'
export default {
  components: {},
  data() {
    return {
      data: [],
    };
  },
  mounted() {
    // Kakao.init('15e7887e87b724b15605d38adf95cf84');
    // Kakao.isInitialized();
    // this.kakaoLogout();
  },
  methods: {
    kakaoLogin() {
      window.location.replace(
        "https://kauth.kakao.com/oauth/authorize?client_id=15e7887e87b724b15605d38adf95cf84&redirect_uri=https://i5a403.p.ssafy.io/api/login/kakao&response_type=code"
      ); //test API
    },
  },
};
</script>
<style>
#login-logo {
  position: absolute;
  top: 30%;
  left: 25%;
  width: 200px;
}
#login-btn {
  position: absolute;
  width: 380px;
  height: 60px;
  top: 50%;
  left: 5%;
}
video {
  display: none;
}
</style>
