<template>
  <div>
    <div class="header">상세페이지</div>
    <el-carousel :interval="0" indicator-position="outside" height="135vw">
      <!-- bear-carousel -->
      <el-carousel-item id="beer-detail">
        <!-- beer img -->
        <div class="detail-beerimg-box">
          <div id="detail-hashtags">
            <div v-for="(hashtag, index) in beerData.hashTags" :key="index">
              <span># {{ hashtag.hashTagName }}&nbsp;</span>
            </div>
          </div>
          <img id="detail-beerimg" :src="beerImage" />
        </div>
        <!-- beer info -->
        <div id="bookmark-beername">
          <h3>{{ beerData.beerName }}</h3>
          <button style="border: none; background: transparent !important" @click="doBookmark">
            <img style="width: 25px" :src="isBookmark ? bookmarkYes : bookmarkNo" alt="" />
          </button>
        </div>
        <el-rate id="detail-rate" v-model="beerData.beerAvg" allow-half disabled show-template="{beerData.beerAvg}"></el-rate>
        <p>{{ countryName }}/{{ beerData.beerCategory }}/{{ beerData.alcoholProof }}</p>
      </el-carousel-item>

      <!-- snack-carousel -->
      <el-carousel-item class="beer-snack" style="magrin: 0px auto">
        <div id="snack-sentence">
          <p>
            <span style="font-size: 16px; font-weight: bold">{{ beerData.beerName }} </span>
            <span style="font-size: 14px">와/과 잘 어울리는 안주는</span><br />
            <span style="font-size: 35px; font-weight: bold; color: #f5df4d">{{ snackData.snackCategory }} 안주</span>
            <span style="font-size: 14px">입니다</span>
          </p>
        </div>
        <div id="snack-card-lists">
          <div id="snack-card-1" v-for="(snack, index) in snackData.snacks" v-bind:key="index">
            <div v-if="index === 0">
              <p>{{ snack.snackName }}</p>
              <img id="snack-img" :src="require('../assets/snacks/' + snack.snackImage + '.png')" alt="" />
            </div>
          </div>
          <div id="snack-card-2">
            <div v-for="(snack, index) in snackData.snacks" v-bind:key="index" style="padding-right: 7%">
              <div v-if="index > 0">
                <p>{{ snack.snackName }}</p>
                <img id="snack-img" :src="require('../assets/snacks/' + snack.snackImage + '.png')" alt="" />
              </div>
            </div>
          </div>
        </div>
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<script>
export default {
  name: "Detail",
  components: {},
  data() {
    return {
      beerData: [],
      snackData: [],
      beerImage: "",
      countryName: "",
      isBookmark: "",
      bookmarkYes: require("../assets/bookmark/bookmark-yes.png"),
      bookmarkNo: require("../assets/bookmark/bookmark-no.png"),
      data: {
        userId: sessionStorage.getItem("userId"),
        beerId: this.$route.params.beerId,
      },
    };
  },
  created() {
    this.getBeerData();
    this.getBookmarkFlag();
  },
  methods: {
    async getBeerData() {
      this.beerData = await this.$api("beer?beerId=" + this.$route.params.beerId, "get");
    },
    async getSnackData() {
      this.snackData = await this.$api("snack?beerCategory=" + this.beerData.beerCategory, "get");
    },
    async getBookmarkFlag() {
      this.isBookmark = await this.$api(
        "bookmark?userId=" + sessionStorage.getItem("userId") + "&beerId=" + this.$route.params.beerId,
        "get"
      );
    },
    async addBookmark() {
      await this.$api("bookmark", "post", this.data);
    },
    async cancelBookmark() {
      await this.$api("bookmark", "delete", this.data);
    },
    doBookmark() {
      this.isBookmark = !this.isBookmark;
      if (this.isBookmark) this.addBookmark();
      else this.cancelBookmark();
    },
  },
  watch: {
    beerData: function () {
      this.beerImage = require("../assets/beers/" + this.beerData.beerImage + ".png");
      this.getSnackData();
      this.countryName = this.beerData.country.countryName;
    },
  },
};
</script>

<style>
@font-face {
  font-family: "양진체";
  src: url("https://cdn.jsdelivr.net/gh/supernovice-lab/font@0.9/yangjin.woff") format("woff");
  font-weight: normal;
  font-style: normal;
}
@font-face {
  font-family: "GmarketSansMedium";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansMedium.woff") format("woff");
  font-weight: normal;
  font-style: normal;
}
@import url("https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400&display=swap");
#bookmark-beername {
  display: flex;
  align-items: flex-end;
  align-self: center;
}
h1 {
  font-family: "Noto Sans KR", sans-serif;
}
p {
  font-family: "GmarketSansMedium";
}
#beer-detail {
  height: 120vw;
  display: flex;
  justify-content: center;
  flex-direction: column;
  margin-top: 4%;
}
.detail-beerimg-box {
  position: relative;
  height: 105vw;
  width: 90%;

  align-self: center;
  display: flex;
  justify-content: center;

  margin: 3% 0 3% 0;
}
#detail-hashtags {
  position: absolute;

  display: flex;
  flex-flow: wrap;
  place-content: center;

  font-family: "양진체";
  font-size: 20px;
  color: #f5df4d;
}
#detail-beerimg {
  position: absolute;
  padding-top: 5%;
  height: 90%;

  object-fit: contain;
}
#beer-detail h3 {
  display: flex;
  justify-content: center;

  font-family: "Noto Sans KR", sans-serif;
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

  font-family: "Noto Sans KR", sans-serif;
  margin: 1%;
}

#beer-detail:nth-child(2n) {
  background-color: white;
}

#beer-detail:nth-child(2n + 1) {
  background-color: white;
}

#snack-sentence {
  padding-left: 3%;
}
#snack-sentence p {
  margin: 2%;
  font-family: "GmarketSansMedium";
}

#snack-card-lists {
  height: 110vw;
  border-radius: 5%;
  background-color: #f5df4d;

  justify-content: center;
}
#snack-card-1 {
  display: flex;
  justify-content: center;
  padding-top: 3%;
}
#snack-card-2 {
  display: flex;
  justify-content: center;

  padding: 0 3% 0 3%;
}
#snack-img {
  display: flex;
  justify-content: center;

  width: 36vw;
  height: 36vw;
  object-fit: contain;
}
#snack-card-lists p {
  display: flex;
  justify-content: center;

  font-weight: blod;

  margin: 5% 0 1% 0;
}
.el-late {
  height: 100px;
}
</style>
