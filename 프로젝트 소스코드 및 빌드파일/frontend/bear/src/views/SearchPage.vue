<template>
  <div>
    <input id="search_input" class="search-input-style" v-model="keyword" @keyup="search" placeholder=" 태그 또는 맥주를 입력하세요" />

    <div class="radio-toolbar">
      <input type="radio" v-model="select" value="account" checked />
      <label @click="this.select = 'account'">계정</label>
      <input type="radio" v-model="select" value="tag" />
      <label @click="this.select = 'tag'">태그</label>
      <input type="radio" v-model="select" value="beer" />
      <label @click="this.select = 'beer'">맥주</label>
    </div>

    <div v-if="select == 'account'" class="result-wrapper">
      <div v-for="(user, index) in users" :key="index" class="mb-4" @click="goToUser(user.userId)">
        <img :src="user.userImage" alt="" class="search-round-image beer-item" />
        <span>{{ user.customId }}</span>
      </div>
    </div>

    <div v-if="select == 'beer'" class="result-wrapper">
      <div v-for="(beer, index) in beers" :key="index" class="mb-4" @click="goToBeer(beer.beerId)">
        <img :src="require('../assets/beers/' + beer.beerImage + '.png')" alt="" class="search-round-image beer-item" />
        <span>{{ beer.beerName }}</span>
      </div>
    </div>

    <div v-if="select == 'tag'" class="result-wrapper">
      <div v-for="(hashTag, index) in tags" :key="index" class="mb-4 flex-box" @click="goToHashTag(hashTag.hashTagId, hashTag.hashTagName)">
        <div class="tag-image">태그</div>
        <span class="tag-text"># {{ hashTag.hashTagName }}</span>
      </div>
    </div>
  </div>
</template>

<script>
import { defineComponent } from "vue";
export default defineComponent({
  data() {
    return {
      category: "beer",
      buttontype: "success",
      resultData: [],
      keyword: "",
      count: 0,
      beers: [],
      tags: [],
      users: [],
      select: "account",
    };
  },
  methods: {
    async search() {
      this.users = await this.$api("search/user?keyword=" + this.keyword, "get");
      this.beers = await this.$api("search/beer?keyword=" + this.keyword, "get");
      this.tags = await this.$api("search/hashtag?keyword=" + this.keyword, "get");
    },
    goToUser(userId) {
      let sessionUser = sessionStorage.getItem("userId");
      localStorage.setItem("searchUserId", userId);
      if (sessionUser == userId) this.$router.push("/myprofile");
      else this.$router.push({ name: "UserProfile", params: { userId: userId } });
    },
    goToBeer(beerId) {
      this.$router.push({ name: "Detail", params: { beerId: beerId } });
    },
    goToHashTag(hashTagId, hashTagName) {
      localStorage.setItem("hashTagId", hashTagId);
      localStorage.setItem("hashTagName", hashTagName);
      this.$router.push("/tag");
    },
  },
});
</script>

<style>
.radio-toolbar {
  text-align-last: center;
}
.radio-toolbar input[type="radio"] {
  position: fixed;
  width: 0;
}
.radio-toolbar label {
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
.radio-toolbar input[type="radio"]:checked + label {
  background-color: #f5df4d;
  font-weight: bold;
  color: #fff;
  text-shadow: -1px 0 #939597, 0 1px blue, 1px 0 #939597, 0 -1px #939597;
}

.search-input-style {
  width: -webkit-fill-available;
  margin: 1%;
  padding: 3%;
  margin: 0 auto;
  border: none; /* <-- This thing here */
  border: solid 1px #ccc;
  border-top-left-radius: 5vw;
  border-top-right-radius: 5vw;
  border-bottom-left-radius: 5vw;
  border-bottom-right-radius: 5vw;
  margin-bottom: 1%;
}
.search-round-image {
  width: 45px;
  height: 45px;
  border-radius: 70%;
  background: #939597;
  overflow: hidden;
  object-fit: scale-down;
}
video {
  display: none;
}
.result-wrapper {
  margin: 2%;
  font-size: large;
  margin-bottom: 2%;
}
.beer-item {
  vertical-align: middle;
  margin-right: 3%;
}
.tag-image {
  width: 45px;
  height: 45px;
  border-radius: 70%;
  background: #939597;
  color: white;
  font-weight: bold;
  text-align: center;
  display: table-cell;
  vertical-align: middle;
  -webkit-text-emphasis-style: filled;
}
.tag-text {
  align-self: center;
  margin-left: 2%;
}
.mb-4 {
  display: flex;
  align-items: center;
  margin-bottom: 4%;
}
.flex-box {
  display: flex;
}
</style>
