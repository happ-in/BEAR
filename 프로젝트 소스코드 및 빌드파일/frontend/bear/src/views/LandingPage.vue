<template>
    <el-carousel width="420px" height="760px">
      <el-carousel-item v-for="(item,index) in items" :key="index">
        <img :src="item.image" />  
        <button id="scanbutton" v-if="item.id === 3" @click="goToAr"><img src="../assets/landing/4-2.png"></button>    
      </el-carousel-item>
    </el-carousel>
</template>
<script>
export default {
  data() {
    return {
      items: [
        {id : 1, image: require('../assets/landing/land1-2.png')},
        {id : 2, image: require('../assets/landing/land2-2.gif')},
        {id : 3, image: require('../assets/landing/land3-2.png')}
      ]
    }
  },
  mounted() {
    if(this.$route.query.accessToken !== undefined){
      sessionStorage.setItem("token", this.$route.query.accessToken);
      sessionStorage.setItem("userId", this.$route.query.userId);
      console.log(sessionStorage.getItem("token"));
    }
  },
  methods: {
    goToAr(){
      this.$router.push('/ar');
    }
  },
}
</script>

<style>
  img{
    border: 0px;
    margin: 0px;
  }
  #scanbutton{
    position: absolute;
    top: 470px;
    left: 125px;
    text-decoration: none;
    background-color: transparent !important;
    border-color: transparent !important;
    border: none;
    outline: none;
  }
</style>