<template>
<div>
  <div class="header">{{ user.customId }}</div>

  <el-row class="profile-user-wrapper">
    <el-col :span="8">
      <el-avatar :src="user.userImage" :size="100" />
    </el-col>
    <el-col :span="1"></el-col>
    <el-col :span="15" style="text-align: left">
      <div class="profile-nickname">{{ user.nickname }}</div>

      <!-- 팔로우/팔로우 취소 -->
      <button plain @click="doFollow" class="profile-btn">
        {{ isFollow ? "팔로우 취소" : "팔로우" }}
      </button>
    </el-col>
  </el-row>

  <!-- 리뷰수/팔로잉/팔로워 -->
  <el-row class="profile-follow-box">
    <el-col :span="8">
      <div class="grid-content bg-purple strong">리뷰수</div>
      <div class="grid-content bg-purple">{{ user.reviewCount }}</div>
    </el-col>
    <el-col :span="8" @click="goToFollowing(user.userId)">
      <div class="grid-content bg-purple-light strong">팔로잉</div>
      <div class="grid-content bg-purple-light">{{ user.followCount }}</div>
    </el-col>
    <el-col :span="8" @click="goToFollower(user.userId)">
      <div class="grid-content bg-purple-light strong">팔로워</div>
      <div class="grid-content bg-purple">{{ user.followerCount }}</div>
    </el-col>
  </el-row>

  <div class="review-wrapper" v-for="(review, index) in reviews" :key="index">
    <el-row :gutter="20" class="review-el-row-body">
      <el-col :span="6" style="text-align: center" @click="goToDetail(review.beer.beerId)">
        <img :src="require('../assets/beers/' + review.beer.beerImage + '.png')" class="grid-content bg-purple review-beerImage" />
      </el-col>
      <el-col :span="14">
        <span class="review-beerName" @click="goToDetail(review.beer.beerId)">
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
            <img :src="review.like ? heartYes : heartNo" class="image" />
          </div>
          <div class="heart-text">
            <button id="heart-button" @click="isLikeFeed(index)" :class="{ likeReview: review.like }">
              {{ review.totalLike }}
            </button>
          </div>
        </div>
      </el-col>
    </el-row>
  </div>
</div>
</template>
<script>
export default {
  name: "UserFollow",
  data() {
    return {
      user: [],
      reviews: [],
      isFollow: "",
      heartYes: require("../assets/redHeart.png"),
      heartNo: require("../assets/heart.png"),
      otherId: localStorage.getItem("searchUserId"),
      myId: sessionStorage.getItem("userId"),
    };
  },
  created() {
    this.getUser();
    this.getReviews();
    this.amIFollow();
  },
  methods: {
    async getUser() {
      this.user = await this.$api("search/userInfo?userId=" + this.otherId, "get");
    },
    async getReviews() {
      this.reviews = await this.$api("review/other?myId=" + this.myId + "&otherId=" + this.otherId, "get");
    },
    async amIFollow() {
      this.isFollow = await this.$api("follower/check?userId=" + this.myId + "&followId=" + this.otherId, "get");
    },
    async follow() {
      let data = { userId: this.myId, followerId: this.otherId };
      await this.$api("follower/addFollow", "post", data);
    },
    async unFollow() {
      let data = { userId: this.myId, followerId: this.otherId };
      await this.$api("follower/deleteFollow", "delete", data);
    },
    async addLike(data) {
      await this.$api("review/like", "post", data);
    },
    async cancelLike(data) {
      await this.$api("review/like", "delete", data);
    },
    isLikeFeed(index) {
      let now = this.reviews[index];
      now.like = !now.like;

      let data = {
        userId: sessionStorage.getItem("userId"),
        reviewId: now.reviewId,
      };

      if (now.like) {
        now.totalLike += 1;
        this.addLike(data);
      } else {
        now.totalLike -= 1;
        this.cancelLike(data);
      }
    }, 
    goToDetail(beerId) {
      this.$router.push({ name: "Detail", params: { beerId: beerId } });
    },
    goToFollowing(userId) {
      this.$router.push({ name: "Follow", params: { header: "팔로잉", userId: userId } });
    },
    goToFollower(userId) {
      this.$router.push({ name: "Follow", params: { header: "팔로워", userId: userId } });
    },
    doFollow() {
      this.isFollow = !this.isFollow;
      if (this.isFollow) this.follow();
      else this.unFollow();
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
.likeReview {
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
