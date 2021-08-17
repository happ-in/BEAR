<template>
  <div class="wrapper-rank-category">
    <h1>{{ this.$route.params.category }}</h1>
    <!-- countryName, beerCategory, alcoholProof 도 추가-->

    <div
      class="rank-category-item-wrapper"
      v-for="(beer, index) in rankData"
      v-bind:key="index"
      :style="{ 'background-color': bgRank[index] }"
    >
      <el-row>
        <el-col :span="3" class="rank-grade"> {{ index + 1 }}위 </el-col>
        <el-col :span="5">
          <img class="beer-image-wrapper" :src="require('../assets/beers/' + beer.beerImage + '.png')" />
        </el-col>
        <el-col :span="16">
          <el-row class="beerName">{{ beer.beerName }}</el-row>
          <el-row class="beer-info-etc">{{ beer.countryName }}/{{ beer.beerCategory }}/{{ beer.alcoholProof }}</el-row>
          <el-row class="total-count-wrapper">
            <span class="total-count-info">{{ beer.totalCount }}</span
            >명이 좋아해요!
          </el-row>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
// import axios from 'axios';

export default {
  name: "RankingCategory", //컴포넌트 이름
  components: {},
  data() {
    //html과 자바스크립트 코드에서 사용할 데이터 변수 선언
    return {
      rankData: [],
      beerImage: "",
      bgRank: ["#F5DF4D", "rgba(245, 223, 77, 0.6)", "rgba(245, 223, 77, 0.2)", "fff", "fff", "fff", "fff"],
    };
  },
  setup() {}, //컴포지션 API
  created() {}, //컴포넌트가 생성되면 실행
  mounted() {
    this.getRankData();
  }, //template에 정의된 html코드가 레너링된 후 실행
  unmounted() {}, //unmount가 완료된 후 실행
  methods: {
    pushBeerId(index) {
      this.$router.push({
        name: "Detail",
        params: { beerId: this.rankData[index].beerId },
      });
      console.log(this.rankData[index]);
    },
    async getRankData() {
      this.rankData = await this.$api("https://i5a403.p.ssafy.io/rank/" + this.$route.params.category, "get");
      this.beerImage = require("../assets/beers/" + this.rankData.beer.beerImage + ".png");
    },
  }, //컴포넌트 내에서 사용할 메소드 정의
};
</script>

<style>
video {
  display: none;
}
.beer-image-wrapper {
  width: 100%;
  height: 120px;
  object-fit: contain;
  padding-top: 10px;
}
.rank-category-item-wrapper {
  box-shadow: 1px 2px 3px grey;
  height: 140px;
  border-top-left-radius: 15px;
  border-top-right-radius: 15px;
  border-bottom-left-radius: 15px;
  border-bottom-right-radius: 15px;
  margin-top: 2%;
}
.rank-grade {
  font-weight: bold;
  text-align: center;
  align-self: center;
}
.beerName {
  margin-top: 3%;
  font-size: large;
  font-weight: bold;
  padding-top: 10px;
}
.beer-info-etc {
  font-size: small;
  color: white;
  text-shadow: -1px 0 #939597, 0 1px #939597, 1px 0 #939597, 0 -1px #939597;
}
.total-count-info {
  color: #2653af;
  font-size: x-large;
  text-shadow: 0px 4px 4px rgb(0 0 0 / 25%);
}
.total-count-wrapper {
  padding-top: 35px;
  align-items: flex-end;
}
</style>
