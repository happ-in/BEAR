<template>
  <div id="login-container">
    <img id="login-logo" src="../assets/landing/logo.png"/>
    <a id="custom-login-btn" @click="kakaoLogin()">
      <img id="login-btn" src="//k.kakaocdn.net/14/dn/btqCn0WEmI3/nijroPfbpCa4at5EIsjyf0/o.jpg" width="380" />
    </a>
  </div>
</template>
<script>
export default {
  components: {},
  data() {
    return {
      data: [],
    };
  },
  methods: {
    kakaoLogin() {
      window.location.replace(
        "https://kauth.kakao.com/oauth/authorize?client_id=15e7887e87b724b15605d38adf95cf84&redirect_uri=https://i5a403.p.ssafy.io/api/login/kakao&response_type=code"
      );
    },
  },
};
</script>
<style>
#login-container {
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
  margin-top:54%;
}
#login-logo {

  width: 200px;
}
#login-btn {
  width: 320px;
  height: 60px;
}
video {
  display: none;
}
</style>
