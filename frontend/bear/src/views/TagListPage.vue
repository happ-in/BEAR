<template>
  <div class="search-header">
    <h2 class="search-header-tag"># {{ hashTagName }}</h2>
    <h2>이 포함된 맥주</h2>
  </div>

  <div class="tag-item-wrapper">
    <el-row v-for="(beer, index) in beers" :key="index" class="tag-item" @click="goToBeer(beer.beerId)">
      <img :src="require('../assets/beers/' + beer.beerImage + '.png')" class="tag-round-image" />
      <div style="margin-left: 5%; align-self: center">
        <div class="h3_style">{{ beer.beerName }}</div>
        <span>{{ beer.beerCategory }}/{{ beer.country.countryName }}/{{ beer.alcoholProof }}</span>
      </div>
    </el-row>
  </div>
</template>
<script>
export default {
  name: "TagList",
  components: {},
  data() {
    //html과 자바스크립트 코드에서 사용할 데이터 변수 선언
    return {
      beers: [],
      hashTagName: "",
    };
  },
  setup() {}, //컴포지션 API
  created() {
    this.getBeerData();
    this.hashTagName = localStorage.getItem("hashTagName");
  }, //컴포넌트가 생성되면 실행
  mounted() {}, //template에 정의된 html코드가 레너링된 후 실행
  unmounted() {}, //unmount가 완료된 후 실행
  methods: {
    async getBeerData() {
      this.beers = await this.$api("beer/search?hashTagId=" + localStorage.getItem("hashTagId"), "get");
    },
    goToBeer(beerId) {
      this.$router.push({ name: "Detail", params: { beerId: beerId } });
    },
  },
};
</script>
<style>
.tag-round-image {
  width: 80px;
  height: 80px;
  border-radius: 70%;
  background: #939597;
  overflow: hidden;
  object-fit: scale-down;
}
.h3_style {
  font-size: x-large;
  font-weight: bold;
}
.tag-item-wrapper {
  width: 100%;
}
.tag-item {
  margin: 3%;
  padding: 3%;
}
.search-header {
  display: flex;
  justify-content: center;
  border-bottom: inset;
  width: 100%;
}
.search-header-tag {
  color: yellow;
  text-shadow: -1px 0 #939597, 0 1px blue, 1px 0 #939597, 0 -1px #939597;
}
</style>
