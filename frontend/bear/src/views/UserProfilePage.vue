<template>
  <h2>{{ user.customId }}</h2>

  <el-row class="profile-user-wrapper">
    <el-col :span="12">
      <el-avatar :src="user.userImage" :size="100" style="margin-right: 4px" />
    </el-col>
    <el-col :span="12" style="text-align: left">
      <div>뱃지명</div>
      <div>{{ user.nickname }}</div>
    </el-col>
  </el-row>

  <!-- 리뷰수/팔로잉/팔로워 -->
  <el-row>
    <el-col :span="8">
      <div class="grid-content bg-purple">리뷰수</div>
      <div class="grid-content bg-purple">{{ user.reviewCount }}</div>
    </el-col>
    <el-col :span="8">
      <div class="grid-content bg-purple-light">팔로잉</div>
      <div class="grid-content bg-purple-light">{{ user.followCount }}</div>
    </el-col>
    <el-col :span="8">
      <div class="grid-content bg-purple">팔로워</div>
      <div class="grid-content bg-purple">{{ user.followerCount }}</div>
    </el-col>
  </el-row>

  <!-- 팔로우/팔로우 취소 -->
  <button plain @click="isFollow = !isFollow" class="profile-btn">
    {{ isFollow ? "팔로우 취소" : "팔로우" }}
  </button>

  <div class="review-wrapper" v-for="(review, index) in reviews" :key="index" @click="goToDetail(review.beer.beerId)">
    <el-row :gutter="20" class="review-el-row-body">
      <el-col :span="6" style="text-align: center">
        <img :src="require('../assets/beers/' + review.beer.beerImage + '.png')" class="grid-content bg-purple review-beerImage" />
      </el-col>
      <el-col :span="14">
        <span class="review-beerName">
          {{ review.beer.beerName }}
          <img :src="require('../assets/flags/' + review.beer.country.countryName + '.png')" style="width: 6%" />
        </span>
        <br />
        <span class="review-beerInfo"
          >{{ review.beer.country.countryName }}/{{ review.beer.beerCategory }}/{{ review.beer.alcoholProof }}</span
        >
        <el-rate v-model="review.rating" allow-half disabled style="margin-bottom: 7%"></el-rate>

        <div>
          <el-tag type="info" v-for="(hashTag, index) in review.hashTags" :key="index" style="margin-right: 1%; margin-bottom: 1%">
            # {{ hashTag.hashTagName }}
          </el-tag>
        </div>
      </el-col>

      <el-col :span="4">
        <div class="review-heart">
          <div class="heart-image">
            <img :src="src" class="image" />
          </div>
          <div class="heart-text">
            <button id="heart-button" @click="isLikeFeed(index)" :class="{ likeFeed: review.like }">
              {{ review.totalLike }}
            </button>
          </div>
        </div>
      </el-col>
    </el-row>
  </div>
</template>
<script>
export default {
  name: "UserFollow", //컴포넌트 이름
  components: {},
  data() {
    //html과 자바스크립트 코드에서 사용할 데이터 변수 선언
    return {
      user: [],
      reviews: [],
      isFollow: false,
      src: require("../assets/heart.png"),
    };
  },
  setup() {}, //컴포지션 API
  created() {
    this.getUser();
    this.getReviews();
  }, //컴포넌트가 생성되면 실행
  mounted() {}, //template에 정의된 html코드가 레너링된 후 실행
  unmounted() {}, //unmount가 완료된 후 실행
  methods: {
    async getUser() {
      this.user = await this.$api("search/userInfo?userId=" + localStorage.getItem("searchUserId"), "get");
    },
    async getReviews() {
      this.reviews = await this.$api("review?userId=" + localStorage.getItem("searchUserId"), "get");
    },
    isLikeFeed(index) {
      let now = this.reviews[index];
      now.like = !now.like;
      if (now.like) {
        now.totalLike += 1;
        this.src = require("../assets/redHeart.png");
      } else {
        now.totalLike -= 1;
        this.src = require("../assets/heart.png");
      }
    }, //컴포넌트 내에서 사용할 메소드 정의
    goToDetail(beerId) {
      this.$router.push({ name: "Detail", params: { beerId: beerId } });
    },
  },
};
</script>
<style>
.review-beerInfo {
  font-size: smaller;
  color: gray;
}
.review-beerName {
  font-size: large;
  font-weight: bold;
}
.review-beerImage {
  height: 120px;
}
.review-wrapper {
  border: 1px solid #9a9a9a42;
  box-shadow: 2px 2px 2px #9a9a9a42;
}
.review-el-row-body {
  margin: 4%;
}
.profile-image {
  margin-left: 30%;
}
.grid-content {
  text-align: center;
}
.mb-4 {
  margin-bottom: 4%;
}
.feed {
  background: gray;
  width: 100%;
  height: 100%;
}
.feed-item {
  background: white;
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
.review-heart {
  position: relative;
  left: 6%;
}
.review-heart img {
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
.profile-user-wrapper {
  margin: 3%;
  align-items: center;
  text-align: center;
}
.profile-user-wrapper > span {
  text-align: left;
}
.profile-btn {
  width: 100%;
  padding: 3%;
  margin-top: 2%;
  margin-bottom: 2%;
  background: white;
  border: 0.5px solid #939597;
}
.profile-btn:active {
  box-shadow: 1px 1px 1px rgb(156, 143, 143);
}
</style>
