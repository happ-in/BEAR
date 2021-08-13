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
img {
  border: none;
}
video {
  display: none;
}
</style>
