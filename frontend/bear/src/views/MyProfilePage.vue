<template>
<div>
  <div class="header">{{ user.customId }}</div>
  <!-- 프로필 -->
  <el-row class="profile-user-wrapper">
    <el-col :span="8">
      <el-avatar :src="user.userImage" :size="100" />
    </el-col>
    <el-col :span="1"></el-col>
    <el-col :span="15">
      <div class="profile-nickname">{{ user.nickname }}</div>
      <!-- 프로필 변경 -->
      <button class="profile-btn" @click="goProfileEdit">프로필 변경</button>
    </el-col>
  </el-row>

  <!-- 리뷰수/팔로잉/팔로워 -->
  <el-row class="profile-follow-box">
    <el-col :span="8">
      <div class="grid-content bg-purple strong">리뷰수</div>
      <div class="grid-content bg-purple">{{ user.reviewCount }}</div>
    </el-col>
    <el-col :span="8" @click="goToFollowing">
      <div class="grid-content bg-purple-light strong">팔로잉</div>
      <div class="grid-content bg-purple-light">{{ user.followCount }}</div>
    </el-col>
    <el-col :span="8" @click="goToFollower">
      <div class="grid-content bg-purple strong">팔로워</div>
      <div class="grid-content bg-purple">{{ user.followerCount }}</div>
    </el-col>
  </el-row>

  <div class="profile-radio-toolbar" style="margin-bottom: 5%">
    <input type="radio" v-model="select" value="bookmark" checked />
    <label @click="this.select = 'bookmark'">북마크</label>
    <input type="radio" v-model="select" value="review" />
    <label @click="this.select = 'review'">리뷰</label>
    <input type="radio" v-model="select" value="badgeItem" />
    <label @click="this.select = 'badgeItem'">뱃지</label>
  </div>

  <!-- 북마크 -->
  <div class="bookmark-list" v-if="this.select == 'bookmark'" style="width: 100%">
    <div class="bookmark-item" v-for="(bookmark, index) in bookmarks" :key="index" @click="goToDetail(bookmark.beerId)">
      <button class="bookmark-btn">
        <img :src="bookmarkImage" alt="" />
      </button>
      <img :src="require('../assets/beers/' + bookmark.beerImage + '.png')" alt="" />
    </div>
  </div>

  <!-- 리뷰 -->
  <div class="review-list" v-if="this.select == 'review'">
    <el-card v-for="(review, index) in reviews" :key="index">
      <!-- 맥주이미지 -->
      <el-row>
        <el-col :span="7" style="text-align: center; padding-right: 6%;">
          <img :src="require('../assets/beers/' + review.beer.beerImage + '.png')" class="grid-content bg-purple" style="height: 120px" />
        </el-col>

        <!-- 제목, 별점, 해시태그 -->
        <el-col :span="14">
          <el-row :gutter="20">
            <span>
              {{ review.beer.beerName }}
              <img :src="require('../assets/flags/' + review.beer.country.countryName + '.png')" style="width: 6%" />
            </span>
            <b></b>
            <el-rate v-model="review.rating" allow-half disabled></el-rate>
          </el-row>

          <div style="position: relative; top: 20px">
            <el-tag type="info" v-for="(hashTag, index) in review.hashTags" :key="index" style="margin-right: 1%; margin-bottom: 1%">
              # {{ hashTag.hashTagName }}
            </el-tag>
          </div>
        </el-col>

        <!-- 하트 -->
        <el-col :span="3" style="display: flex; flex-direction: column; justify-content: space-between">
          <div class="heart-wrapper">
            <div class="heart-image">
              <img :src="review.like ? heartYes : heartNo" />
            </div>
            <div class="heart-text">
              <button id="heart-button" @click="isLikeFeed(index)" :class="{ likeFeed: review.like }">
                {{ review.totalLike }}
              </button>
            </div>
          </div>

          <!-- 드롭다운 -->
          <el-dropdown class="dropdown">
            <span class="el-dropdown-link">
              <more style="width: 20px; height: 20px; margin-left: 8px; color: #939597" />
            </span>
            <template #dropdown>
              <el-dropdown-menu>
                <el-dropdown-item
                  @click="
                    sendLink(
                      review.beer.beerId,
                      review.beer.beerName,
                      'https://i5a403.p.ssafy.io' + require('../assets/beers/' + review.beer.beerImage + '.png'),
                      review.hashTags
                    )">공유</el-dropdown-item>
                <el-dropdown-item @click="deletereview(review.reviewId)">삭제</el-dropdown-item>
              </el-dropdown-menu>
            </template>
          </el-dropdown>
        </el-col>
      </el-row>
    </el-card>
  </div>

  <!-- 뱃지 -->
  <div class="badge-list" v-if="this.select == 'badgeItem'">
    <el-row>
      <el-col :span="12" style="text-align: -webkit-center;" v-for="(badge, index) in badges" :key="index">
        <el-button class="badge-button" type="text" @click="centerDialogVisible[index] = true" style="color: black;">
          <!-- 뱃지 미획득시 이미지(흑백)-->
          <div v-if="badge.gain == false" style="text-align: -webkit-center;">
            <div style="border-radius: 50%; height: 120px; width: 120px; background-color: white; margin: 0px">
              <img :src="require('../assets/badge/' + badge.badgeImage + '.png')" width="120" style="mix-blend-mode: luminosity" />
            </div>
          </div>
          <!-- 뱃지 획득시 이미지(컬러)-->
          <div v-else>
            <img :src="require('../assets/badge/' + badge.badgeImage + '.png')" width="120" />
          </div>
          <p>{{ badge.title }}</p>
        </el-button>

        <!-- 뱃지모달 -->
        <el-dialog title="뱃지" v-model="centerDialogVisible[index]" width="80%" center>
          <div style="text-align: center; padding:0; margin-bottom:10%">
            <h2 style="margin-top:0;">{{badge.title}}</h2>
            <div v-if="badge.gain == false" style="text-align: -webkit-center">
              <div style="border-radius: 50%; height: 120px; width: 120px; background-color: white; margin: 0px">
                <img :src="require('../assets/badge/' + badge.badgeImage + '.png')" width="120" style="mix-blend-mode: luminosity" /> <br />
              </div>
            </div>
            <div v-else><img :src="require('../assets/badge/' + badge.badgeImage + '.png')" width="120" /> <br /></div>
            <h4>{{ badge.acquisitionDate ? badge.acquisitionDate : "미획득" }}</h4>
            <span>
              획득방법: <br />
              {{ badge.explain }}
            </span>
          </div>
        </el-dialog>
      </el-col>
      <el-col :span="8"></el-col>
      <el-col :span="8"></el-col>
    </el-row>
  </div>
</div>
</template>
<script>
import { More } from "@element-plus/icons";
export default {
  name: "UserFollow", //컴포넌트 이름
  components: {
    [More.name]: More,
  },
  data() {
    //html과 자바스크립트 코드에서 사용할 데이터 변수 선언
    return {
      heartYes: require("../assets/redHeart.png"),
      heartNo: require("../assets/heart.png"),
      userId: "",
      radio: "북마크",
      centerDialogVisible: [],
      user: {
        userId: "",
        customId: "",
        userImage: "",
        nickname: "",
        sex: "",
        shareCount: "",
        reviewCount: "",
        followCount: "",
        followerCount: "",
      },
      reviews: {
        reviewId: "",
        beerName: "",
        beerImage: "",
        countryImg: "",
        rating: "",
        hashTags: [],
        totalLike: "",
        isLike: "",
      },

      isFollow: false,
      src: require("../assets/heart.png"),
      bookmarks: [],
      bookmarkImage: require("../assets/bookmark/bookmark-yes.png"),
      isBookmark: true,
      select: "bookmark",
      badges: [],
    };
  },
  mounted() {
    this.userId = sessionStorage.getItem("userId");
    this.getUserData();
    this.getBookmarks();
    this.getReviewBeer();
    this.getBadge();
  },
  unmounted() {},
  methods: {
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
    }, //컴포넌트 내에서 사용할 메소드 정의
    goToFollowing() {
      this.$router.push({ name: "Follow", params: { header: "팔로잉", userId: this.userId } });
    },
    goToFollower() {
      this.$router.push({ name: "Follow", params: { header: "팔로워", userId: this.userId } });
    },
    goProfileEdit() {
      this.$router.push({ name: "ProfileEdit" });
    },
    goToDetail(beerId) {
      this.$router.push({ name: "Detail", params: { beerId: beerId } });
    },
    async getBookmarks() {
      this.bookmarks = await this.$api("search/bookmark?userId=" + this.userId, "get");
    },
    async getUserData() {
      this.user = await this.$api("search/userInfo?userId=" + this.userId, "get");
    },
    async getReviewBeer() {
      this.reviews = await this.$api("review?userId=" + this.userId, "get");
    },
    async getBadge() {
      this.badges = await this.$api("search/badge?userId=" + this.userId, "get");
    },
    async addLike(data) {
      await this.$api("review/like", "post", data);
    },
    async cancelLike(data) {
      await this.$api("review/like", "delete", data);
    },
    async deletereview(data) {
      await this.$api("review?reviewId=" + data, "delete");
      this.getReviewBeer();
    },
    async sendLink(id, title, image, hashtaglist) {
      let hashtags = "";
      await this.$api("user/share?userId=" + this.userId, "get");
      for (var hashtag in hashtaglist) {
        hashtags += "#" + hashtaglist[hashtag].hashTagName;
      }
      Kakao.Link.sendDefault({
        objectType: "feed",
        content: {
          title: title,
          description: hashtags,
          imageUrl: image,
          link: {
            mobileWebUrl: "https://i5a403.p.ssafy.io",
            webUrl: "https://i5a403.p.ssafy.io",
          },
        },
        buttons: [
          {
            title: "bear로 이동하기",
            link: {
              mobileWebUrl: "https://i5a403.p.ssafy.io/detail/" + id,
              webUrl: "https://i5a403.p.ssafy.io/detail/" + id,
            },
          },
        ],
      });
    },
  },
};
</script>
<style>
.bookmark-btn {
  border: none;
  background-color: transparent !important;
}
.bookmark-btn > img {
  width: 20px;
}
.bookmark-item {
  display: inline-block;
  width: 30%;
  border: 1px solid grey;
  margin: 1%;
}
.bookmark-item > img {
  height: 100px;
  width: 100%;
  object-fit: contain;
}

.profile-radio-toolbar {
  text-align-last: center;
}
.profile-radio-toolbar input[type="radio"] {
  position: fixed;
  width: 0;
}
.profile-radio-toolbar label {
  display: inline-block;
  background-color: #fff;
  font-size: 16px;
  width: 28%;
  text-align: center;
  font-weight: bold;
  padding: 2%;
  box-shadow: 2px 2px 2px #939597;
  margin-right: 1%;
}
.profile-radio-toolbar input[type="radio"]:checked + label {
  background-color: #939597;
  font-weight: bold;
  color: #fff;
  text-shadow: -1px 0 #939597, 0 1px black, 1px 0 #939597, 0 -1px #939597;
}
.badge-button {
  display: flex;
  flex-direction: column;
}
.profile-user-wrapper {
  padding-top: 12px;
  margin: 3%;
  align-items: center;
  text-align: center;
}
.profile-user-wrapper > span {
  text-align: left;
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
.heart-wrapper {
  position: relative;
  left: 5%;
}
.heart-wrapper img {
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
.el-dropdown-link {
  cursor: pointer;
  color: #409eff;
}
.el-icon-arrow-down {
  font-size: 12px;
}
.el-dialog__header {
  padding-bottom: 0;
}
.el-card__body {
  padding: 10px;
}
/* tabbar padding */
.bookmark-list {
  padding-bottom: 20vw;
}
.review-list {
  padding-bottom: 37vw;
}
.badge-list {
  padding-bottom: 20vw;
}
</style>
