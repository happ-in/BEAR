<template>
  <div class="random-wrapper">
    <div class="card">
      <h1 class="header">랜덤 추천</h1>

      <h2 class="random-beer-name">
        {{ beer.beerName }}
        <img :src="countryImage" />
      </h2>

      <div class="random-beerimg-box"><img :src="beerImage" /></div>
      <ul class="hashtag">
        <li v-for="(hashtag, index) in beer.hashTags" :key="index">
          <p># {{ hashtag.hashTagName }}</p>
        </li>
      </ul>

      <div id="btn">
        <a href="#" class="button" id="repeatbtn" @click="retry">
          <svg fill="none" xmlns="http://www.w3.org/2000/svg">
            <path d="M8 4V0L3 5l5 5V6a6 6 0 11-6 6H0a8 8 0 108-8z" fill="#939597" />
          </svg>
          다시하기
        </a>
        <a href="#" class="button" id="detailbtn" @click="this.$router.push({ name: 'Detail', params: { beerId: beer.beerId } })">
          상세페이지
        </a>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Recommendation", 
  data() {
    return {
      beer: [],
      countryImage: "",
      beerImage: "",
    };
  },
  created() {
    this.retry();
  },
  methods: {
    async retry() {
      this.beer = await this.$api("beer/random", "get");
      this.countryImage = require("../assets/flags/" + this.beer.country.countryName + ".png");
      this.beerImage = require("../assets/beers/" + this.beer.beerImage + ".png");
    },
  }, 
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400&display=swap");
@font-face {
    font-family: 'GmarketSansMedium';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansMedium.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
.random-wrapper {
  position: absolute;
  width: 102%;
  height: 101%;
  left: -4px;
  top: -5px;

  display: flex;
  flex-direction: column;
  align-items: center;

  font-family: "Noto Sans KR", sans-serif;

  background: linear-gradient(
    180deg,
    rgba(245, 223, 77, 0) 0%,
    rgba(245, 223, 77, 0.453125) 21.88%,
    rgba(245, 223, 77, 0.945675) 36.98%,
    #f5df4d 100%
  );
}
.card {
  margin-top: 1%;

  display: flex;
  justify-content: center;
  flex-direction: column;
  width: 291px;
}
.random-beerimg-box {
  display: flex;
  justify-content: flex-start;

  margin-top: 3px;
  margin-bottom: 4px;
  padding-left: 2%;
  
  font-family: "Noto Sans KR", sans-serif;
  font-style: normal;
  font-weight: 400;
  font-size: 25px;

  color: #000000;
}
.random-beer-name {
  font-family: 'GmarketSansMedium';
  margin: 4% 0 2% 2%;
}
.random-beer-name img {
  position: inline;
  vertical-align: middle;
  align-self: center;
  padding-left: 1%;
  padding-bottom: 2px;

  font-family: 'GmarketSansMedium';
  width: 24px;
  height: 24px;
  bottom: 10px;
}
.random-beerimg-box {
  position: relative;
  width: 291px;
  height: 375px;

  background: #ffffff;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
}
.random-beerimg-box img {
  position: absolute;
  top: 20px;
  left: 0;
  width: 100%;
  height: 90%;
  object-fit: contain;
}
#btn {
  display: flex;
  justify-content: space-around;

  text-align: center;
}
#repeatbtn {
  width: 144px;
  height: 43px;

  background: #ffffff;
  border: 1px solid #939597;
  box-sizing: border-box;

  text-decoration: none;

  font-family: "Noto Sans KR", sans-serif;
  font-style: normal;
  font-weight: bold;
  font-size: 15px;
  line-height: 40px;

  color: #939597;
}
#repeatbtn svg {
  padding-top: 10px;
  width: 16px;
  height: 20px;
}
#detailbtn {
  width: 144px;
  height: 43px;

  background: #939597;
  border: 1px solid #939597;
  box-sizing: border-box;

  text-decoration: none;

  font-family: "Noto Sans KR", sans-serif;
  font-style: normal;
  font-weight: bold;
  font-size: 15px;
  line-height: 38px;
  color: white;
}
.hashtag {
  list-style: none;
  top: 73%;
  width: 280px;
  padding-left: 2vw;

  columns: 2;
  -webkit-columns: 2;
  -moz-columns: 2;

  color: #ffffff;
}
.hashtag li {
  width: 140px;
}
.hashtag p {
  position: relative;
  margin: 0px;
  width: 140px;

  text-align: left;
  text-shadow: -1px 0 #939597, 0 1px #939597, 1px 0 #939597, 0 -1px #939597;
  font-family: 'GmarketSansMedium';
  font-style: normal;
  font-weight: bold;
  font-size: 20px;

  color: #ffffff;
}
video {
  display: none;
}
</style>
