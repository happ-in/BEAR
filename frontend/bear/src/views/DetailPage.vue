<template>
  <div>
    <h1>상세페이지</h1>
    <el-carousel :interval="0" indicator-position="outside" height="130vw">
      <el-carousel-item id="beer-detail" >
        <div id="detail-beerimg-box" style="height:90vw; width:150vw; text-align-last:center; align-self:center; margin-bottom:3%;"><img :src="beerImage" /></div>
        <h3>{{ beerData.beerName }}</h3>
        <el-rate id="detail-rate" v-model="beerData.beerAvg" allow-half disabled show-template="{beerData.beerAvg}"></el-rate>
        <p>{{ beerData.contryName}}/{{ beerData.beerCategory }}/{{ beerData.alcoholProof }}</p>
        <!-- {{ beerData.country.countryName }} -->
        <div></div>
      </el-carousel-item>
      <el-carousel-item class="beer-snack" style="background-color:white;">
            <div class="snack-sentence">
                <p class="snack-sentence"><span style="font-size:18px;">{{ beerData.beerName }}과 잘 어울리는 안주는</span><br>
                <span style="font-size:40px; font-weight:bold;">{{ snackData.snackCategory }} 안주</span>
                <span style="font-size:18px;">입니다</span></p>
            </div>
          
          <div id="snack-card" v-for="(snack, index) in snackData.snacks" v-bind:key="index">
            <img id="snack-img" :src='require("../assets/snacks/" + snack.snackImage + ".png")' alt="" />
            <p>{{ snack.snackName }}</p>
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
      console.log(this.beerImage)
    },
    async getSnackData() {
      this.snackData = await this.$api("https://i5a403.p.ssafy.io/snack?beerCategory=" + this.beerData.beerCategory, "get");
      this.snackImage = require("../assets/snacks/" + this.snackData.snacks.snackImage + ".png");
      console.log(this.snackData)
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
#beer-detail {
    height: 120vw;
    display: flex;
    justify-content: center;
    flex-direction: column;
    margin-top: 4%;
}
#detail-beerimg-box img {
    padding-top: 5%;
    height: 90%;
    object-fit: contain;
}
#beer-detail h3 {
    display: flex;
    justify-content: center;
    font-size: 22px;
    opacity: 0.75;
    margin: 0;
}
#detail-rate {
    display: flex;
    justify-content: center;
}
#beer-detail p {
    display: flex;
    justify-content: center;
    margin:1%;
}

#beer-detail:nth-child(2n) {
  background-color: white;
}

#beer-detail:nth-child(2n + 1) {
  background-color: white;
}
#snack-sententce {
    margin-left: 3%;
}
#snack-img {
    display: flex;
    justify-content: center;

    width: 50vw;
    height: 50vw;
    object-fit: contain;
}
.el-late {
    height: 100px;
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
