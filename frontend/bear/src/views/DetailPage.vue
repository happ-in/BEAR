<template>
  <div>
    <h1>상세페이지</h1>
    <el-carousel :interval="0" indicator-position="outside" height="150vw">
      <el-carousel-item class="beer-detail" height="80%">
        <div class="detail-beerimg-box"><img :src="beerImage" /></div>
        <h3>{{ beerData.beerName }}</h3>
        <el-rate v-model="value" disabled show-score text-color="#ff9900" score-template="{ beerData.beerAvg } points"></el-rate>
        <p>/{{ beerData.beerCategory }}/{{ beerData.alcoholProof }}</p>
        <!-- {{ beerData.country.countryName }} -->
        <div></div>
      </el-carousel-item>
      <el-carousel-item id="beer-snack" height="80%">
        <div>
          <h1>{{ beerData.beerName }}과 잘 어울리는 안주는 {{ snackData.snackCategory }} 안주 입니다</h1>
          <div id="snack-card" v-for="(snack, index) in snackData" v-bind:key="index">
            <img src="" alt="" />
            <p>{{ snack.snackName }}</p>
          </div>
        </div>
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<script>
export default {
  name: "Detail", //컴포넌트 이름
  components: {},
  data() {
    //html과 자바스크립트 코드에서 사용할 데이터 변수 선언
    return {
      beerData: [],
      snackData: [],
      beerImage: "",
    };
  },
  setup() {}, //컴포지션 API
  created() {
    this.getBeerData();
  }, //컴포넌트가 생성되면 실행
  mounted() {}, //template에 정의된 html코드가 레너링된 후 실행
  unmounted() {}, //unmount가 완료된 후 실행
  methods: {
    async getBeerData() {
      this.beerData = await this.$api("https://i5a403.p.ssafy.io/beer?beerId=" + this.$route.params.beerId, "get");
      this.beerImage = require("../assets/beers/" + this.beerData.beerImage + ".png");
      consloe.log(this.beerImage)
    },
    async getSnackData() {
      this.snackData = await this.$api("https://i5a403.p.ssafy.io/snack?beerCategory=" + this.beerData.beerCategory, "get");
    },
  }, //컴포넌트 내에서 사용할 메소드 정의
  watch: {
    beerData: function () {
      this.getSnackData();
    },
  },
};
</script>

<style>
.beer-detail {
    height: 100%;
    display: flex;
    justify-content: center;
    flex-direction: column;
}
.detail-bearimg-box{
    display: flex;
    justify-content: center;

    width: 100px;
    height: 500px;

    background: #ffffff;
    box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
}
.detail-beerimg-box img {

    width: 200px;
    height: 200px;
    object-fit: contain;
}
.beer-detail h3 {
    display: flex;
    justify-content: center;
    font-size: 18px;
    opacity: 0.75;
    margin: 0;
}

.beer-detail:nth-child(2n) {
  background-color: white;
}

.beer-detail:nth-child(2n + 1) {
  background-color: white;
}

/* .detail-bearimg-box{
    position: relative;
    width: 291px;
    height: 375px;

    background: #ffffff;
    box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
}
.detail-beerimg-box img {
  position: absolute;
  top: 20px;
  left: 0;
  width: 100%;
  height: 90%;
  object-fit: contain;
} */
</style>
