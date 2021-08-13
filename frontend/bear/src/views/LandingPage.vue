<template>
  <div class="block">
    <el-carousel width="360px" height="640px">
      <el-carousel-item v-for="item in items" :key="item">
        <img :src="item.image" />  
        <button id="scanbutton" v-if="item.id === 3" @click="goToAr"><img src="../assets/landing/4.png"></button>    
      </el-carousel-item>
    </el-carousel>
  </div>
</template>
<script>
export default {
  data() {
    return {
      items: [
        {id : 1, image: require('../assets/landing/1.png')},
        {id : 2, image: require('../assets/landing/2.png')},
        {id : 3, image: require('../assets/landing/3.png')}
      ]
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
  .el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 150px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }

  img{
    border: 0px;
    margin: 0px;
  }

  #scanbutton{
    position: absolute;
    top: 360px;
    left: 90px;
    text-decoration: none;
    background-color: transparent !important;
    border-color: transparent !important;
    border: none;
    outline: none;
  }
  
  video{
    display: none;
  }
</style>