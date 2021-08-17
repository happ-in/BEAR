<template>
  <h2>홈피드</h2>

  <div class="feed-wrapper">
    <el-row :gutter="20" class="feed-el-row-header">
      <el-col :span="8">
        <div @click="this.$router.push('/profile')">
          <span>
            <el-avatar :size="25" :src="user.userImage" style="margin-right: 4px"> </el-avatar>
            {{ user.customId }}
          </span>
        </div>
      </el-col>

      <el-col :span="11"> </el-col>

      <el-col :span="5">
        <div class="heart-wrapper">
          <div class="heart-image">
            <img :src="src" class="image" />
          </div>
          <div class="heart-text">
            <button id="heart-button" @click="isLikeFeed" :class="{ likeFeed: beer.isLike }">
              {{ beer.totalLike }}
            </button>
          </div>
        </div>
      </el-col>
    </el-row>

    <el-row :gutter="20" class="feed-el-row-body">
      <el-col :span="8"><img :src="beer.beerImage" class="grid-content bg-purple" style="width: 100%" /> </el-col>
      <el-col :span="16">
        <span>
          {{ beer.beerName }}
          <img :src="beer.countryImg" style="width: 6%" />
        </span>
        <el-rate v-model="beer.rating" allow-half disabled style="margin-bottom: 5%"></el-rate>

        <div>
          <el-tag type="info" v-for="(hashTag, index) in beer.hashTags" :key="index" style="margin-right: 1%; margin-bottom: 1%">
            # {{ hashTag.hashTagName }}
          </el-tag>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "Feed", //컴포넌트 이름
  components: {},
  data() {
    //html과 자바스크립트 코드에서 사용할 데이터 변수 선언
    return {
      user: {
        userImage: "https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png",
        customId: "happ-in",
      },
      beer: {
        beerName: "시메이 화이트 트리펠",
        beerImage: "https://assets.business.veluga.kr/media/public/Chimay_Chimay_TripelCinq_Cents_4SYlnWG.png",
        countryImg: "https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/Flag_of_Belgium.svg/240px-Flag_of_Belgium.svg.png",
        rating: 4.5,
        hashTags: [{ hashTagName: "트라피스트" }, { hashTagName: "명품" }, { hashTagName: "과일향" }, { hashTagName: "향신료" }],
        totalLike: 10,
        isLike: false,
      },
      src: require("../assets/heart.png"),
    };
  },
  setup() {}, //컴포지션 API
  created() {}, //컴포넌트가 생성되면 실행
  mounted() {}, //template에 정의된 html코드가 레너링된 후 실행
  unmounted() {}, //unmount가 완료된 후 실행
  methods: {
    isLikeFeed() {
      this.beer.isLike = !this.beer.isLike;
      if (this.beer.isLike) {
        this.beer.totalLike += 1;
        this.src = require("../assets/redHeart.png");
      } else {
        this.beer.totalLike -= 1;
        this.src = require("../assets/heart.png");
      }
    },
  }, //컴포넌트 내에서 사용할 메소드 정의
};
</script>
<style>
@import url("//unpkg.com/element-plus/lib/theme-chalk/index.css");

span {
  display: flex;
}
#heart-button {
  text-decoration: none;
  background-color: transparent !important;
  border-color: transparent !important;
  border: none;
  outline: none;
}
button:active {
  color: inherit;
}
.text {
  font-size: 14px;
}
.item {
  margin-bottom: 18px;
}
.heart-wrapper {
  position: relative;
  left: 5%;
}
.heart-image img {
  width: 60%;
  vertical-align: middle;
}
.heart-text {
  font-size: 10pt;
  padding: 5px 10px;
  text-align: center;
  position: absolute;
  left: 30%;
  top: 48%;
  transform: translate(-50%, -50%);
}
.likeFeed {
  color: white;
}
video {
  display: none;
}
.feed-wrapper {
  border: 1px solid #9a9a9a42;
  box-shadow: 2px 2px 2px #9a9a9a42;
}
.feed-el-row-header {
  border-bottom: 1px solid #9a9a9a42;
  padding-top: 2%;
  padding-left: 2%;
  padding-bottom: 3%;
  margin-left: 2%;
}
.feed-el-row-body {
  margin: 4%;
}
</style>
