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
    // Kakao.init('15e7887e87b724b15605d38adf95cf84');
    // Kakao.isInitialized();
    // this.kakaoLogout();
    console.log(this.$route.query.accessToken);
    console.log(this.$route.query.userId);
    
  },
  methods: {
    kakaoLogin(){
      window.location.replace("https://kauth.kakao.com/oauth/authorize?client_id=15e7887e87b724b15605d38adf95cf84&redirect_uri=http://localhost:8080/login/kakao&response_type=code"); //test API
    },
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