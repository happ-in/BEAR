<template>
  <div class="wrapper-rank-category">
    <h1 class="header">{{ headerTitle[this.$route.params.category] }}</h1>
    <div class="rank-category-list">
      <div
        class="rank-category-item-wrapper"
        v-for="(beer, index) in rankData"
        v-bind:key="index"
        :style="{ 'background-color': bgRank[index] }"
        @click="goToDetail(beer.beerId)"
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
  </div>
</template>

<script>
export default {
  name: "RankingCategory", 
  components: {},
  data() {
    return {
      rankData: [],
      bgRank: ["#F5DF4D", "rgba(245, 223, 77, 0.6)", "rgba(245, 223, 77, 0.2)", "fff", "fff", "fff", "fff"],
      headerTitle: {
        all: "전체",
        lager: "라거",
        ale: "에일",
        wheat: "밀맥주",
        stout: "스타우트",
        rtd: "라들러/RTD",
      },
    };
  },
  mounted() {
    this.getRankData();
  },
  methods: {
    pushBeerId(index) {
      this.$router.push({
        name: "Detail",
        params: { beerId: this.rankData[index].beerId },
      });
    },
    async getRankData() {
      this.rankData = await this.$api("https://i5a403.p.ssafy.io/api/rank/" + this.$route.params.category, "get");
    },
    goToDetail(beerId) {
      this.$router.push({ name: "Detail", params: { beerId: beerId } });
    },
  },
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
.rank-category-list {
  margin-bottom: 20vw;
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
