<template>
  <div id="container">
    <el-input
      id="search_input"
      class="inline-input"
      v-model="keyword"
      @input="submitAutoComplete"
      :fetch-suggestions="querySearch"
      placeholder="태그 또는 맥주를 입력하세요"
      prefix-icon="el-icon-search"
      @select="handleSelect"
      style="width: 309px"
    ></el-input>

    <el-button-group style="margin-top: 60px">
      <el-button type="warning" plain style="width: 120px" @click="this.category = 'account'">계정</el-button>
      <el-button type="warning" plain style="width: 120px" @click="this.category = 'tag'"> 태그</el-button>
      <el-button type="warning" autofocus plain style="width: 120px" @click="this.category = 'beer'">맥주</el-button>
    </el-button-group>
    <!-- 
    <ul class="infinite-list" v-infinite-scroll="load" style="overflow: auto" v-if="category == 'beer'">
      <li v-for="(beer, index) in beers" class="infinite-list-item" :key="index">
        {{ beer.beerName }}
      </li>
    </ul>
    
    <ul class="infinite-list" v-infinite-scroll="load" style="overflow: auto" v-if="category == 'tag'">
      <li v-for="(hashTag, index) in tags" class="infinite-list-item" :key="index">
        {{ hashTag.hashTagName }}
      </li>
    </ul>
     -->

    <div v-if="category == 'beer'" class="result-wrapper">
      <div v-for="(beer, index) in beers" :key="index" class="mb-4">
        <!-- <el-avatar class="item" :size="40" :src="require('../assets/beers/' + beer.beerImage + '.png')"></el-avatar> -->
        <img :src="require('../assets/beers/' + beer.beerImage + '.png')" alt="" class="round-image beer-item" />
        <span>{{ beer.beerName }}</span>
      </div>
    </div>

    <div v-if="category == 'tag'" class="result-wrapper">
      <div v-for="(hashTag, index) in tags" :key="index" class="mb-4" style="display: flex">
        <!-- <span class="tag-image item">태그</span> -->
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
    };
  },
  methods: {
    async search() {
      this.beers = await this.$api("https://i5a403.p.ssafy.io/search/beer?keyword=" + this.keyword, "get");
      this.tags = await this.$api("https://i5a403.p.ssafy.io/search/hashtag?keyword=" + this.keyword, "get");
    },
    setCategory(data) {
      this.category = data;
    },
    load() {
      this.count += 2;
    },
  },
  watch: {
    keyword: function () {
      if (this.keyword !== "") this.search();
      else {
        this.beers = [];
        this.tags = [];
      }
    },
  },
});
</script>

<style>
#container {
  position: relative;
  width: 360px;
  height: 640px;

  background: white;
}

#search_input {
  position: absolute;
  width: 309px;
  height: 40px;
  left: 0px;
  top: 0px;
}
.round-image {
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
  margin-bottom: 4%;
}
</style>
