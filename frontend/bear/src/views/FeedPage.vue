<template>
  <div class="homefeed-wrap">
    <div class="header">홈피드</div>
    <div class="feed-list">
      <div class="feed-wrapper" v-for="(feed, index) in feeds" :key="index">
        <el-row :gutter="20" class="feed-el-row-header">
          <el-col :span="3" @click="goToUser(feed.user.userId)">
            <img :src="feed.user.userImage" alt="" class="feed-round-image" />
          </el-col>
          <el-col :span="16" class="feed-customId" @click="goToUser(feed.user.userId)">
            {{ feed.user.customId }}
          </el-col>

          <!-- 하트 -->
          <el-col :span="5">
            <div class="heart-wrapper">
              <div class="heart-image">
                <img :src="feed.like ? redHeart : whiteHeart" class="image" />
              </div>
              <div class="heart-text">
                <button class="heart-button" @click="isLikeFeed(index)" :class="{ likeFeed: feed.like }">
                  {{ feed.totalLike }}
                </button>
              </div>
            </div>
          </el-col>
        </el-row>

        <el-row :gutter="20" class="feed-el-row-body" @click="goToDetail(feed.beer.beerId)">
          <el-col :span="8" style="text-align: center">
            <img :src="require('../assets/beers/' + feed.beer.beerImage + '.png')" class="grid-content bg-purple" style="height: 120px; padding-left: 3%" />
          </el-col>
          <el-col :span="16">
            <span style="display: flex; font-size: large; font-weight: bold">
              {{ feed.beer.beerName }}
              <img
                :src="require('../assets/flags/' + feed.beer.country.countryName + '.png')"
                style="width: 20px; height: 20px; align-self: center; padding-left: 2%;"
              />
            </span>
            <el-rate v-model="feed.rating" allow-half disabled style="margin-bottom: 5%"></el-rate>

            <div>
              <el-tag type="info" v-for="(hashTag, index) in feed.hashTags" :key="index" style="margin-right: 1%; margin-bottom: 1%">
                # {{ hashTag.hashTagName }}
              </el-tag>
            </div>
          </el-col>
        </el-row>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Feed", 
  components: {},
  data() {
    return {
      feeds: [],
      heartImage: "",
      redHeart: require("../assets/redHeart.png"),
      whiteHeart: require("../assets/heart.png"),
    };
  },
  setup() {}, 
  created() {
    this.getFeeds();
  }, 
  methods: {
    isLikeFeed(index) {
      let now = this.feeds[index];
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
    async getFeeds() {
      this.feeds = await this.$api("feed?userId=" + sessionStorage.getItem("userId"), "get");
    },
    goToUser(userId) {
      localStorage.setItem("searchUserId", userId);
      this.$router.push("/profile");
    },
    goToDetail(beerId) {
      this.$router.push({ name: "Detail", params: { beerId: beerId } });
    },
    async addLike(data) {
      await this.$api("review/like", "post", data);
    },
    async cancelLike(data) {
      await this.$api("review/like", "delete", data);
    },
  },
};
</script>
<style>
@import url("//unpkg.com/element-plus/lib/theme-chalk/index.css");

.feed-round-image {
  width: 40px;
  height: 40px;
  border-radius: 70%;
  background: #939597;
  overflow: hidden;
  object-fit: scale-down;
}
.feed-customId {
  align-self: center;
  padding-left: 1%;
  font-size: large;
  font-weight: bold;
}
.heart-button {
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
.feed-list {
  padding-bottom: 20vw;
}
.feed-wrapper {
  border: 1px solid #9a9a9a42;
  box-shadow: 2px 2px 2px #9a9a9a42;
  margin-top: 12px;
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
