<template>
  <div>
    <a id="custom-login-btn" @click="kakaoLogin()">
      <img
        src="//k.kakaocdn.net/14/dn/btqCn0WEmI3/nijroPfbpCa4at5EIsjyf0/o.jpg"
        width="222"
      />
    </a>
    <button id="custom-logout-btn" type="button" @click="kakaoLogout">카카오 로그아웃</button>
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
    // Kakao.init('fa7ca4339835a3b0d37662fbf0b78fb8');
    // Kakao.isInitialized();
    // this.kakaoLogout();
  },
  methods: {
    async kakaoLogin(){
      this.data = await this.$api("https://kauth.kakao.com/oauth/authorize?client_id=15e7887e87b724b15605d38adf95cf84&redirect_uri=http://localhost:8080/kakao/login&reponse_type=code","post"); //test API
      console.log(session.getAttribute("accessToken"));
      console.log(sessionStorage.getItem("accessToken"));
      this.$router.push('/');

    }
  },
};
</script>
<style>
    #custom-login-btn{
        position: absolute;
        width: 40px;
        height: 40px;
        top: 65%;
        left: 50%; 
    }
    #custom-logout-btn{
        position: absolute;
        width: 140px;
        height: 40px;
        top: 65%;
        left: 40%; 
    }
    video{
    display: none;
    }
</style>