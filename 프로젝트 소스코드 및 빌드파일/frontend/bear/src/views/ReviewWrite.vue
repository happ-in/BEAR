<template>
  <div>
    <el-row>
      <el-col :span="6"> </el-col>
      <el-col :span="12">
        <div class="header">리뷰</div>
      </el-col>
      <el-col :span="6">
        <el-button round style="padding: 8px 16px; float: right" @click="regist">등록</el-button>
      </el-col>
    </el-row>

    <el-card class="box-card" style="margin-top: 2%; padding-bottom: 2%">
      <div style="display: flex">
        <span style="font-size: larger; font-weight: bold">'{{ beer.beerName }}'</span>
        <span style="align-self: flex-end">어떠셨나요?</span>
      </div>

      <div style="text-align: center">
        <p>별표를 드래그하세요.</p>
        <el-rate v-model="rating" allow-half />
      </div>

      <div style="margin-top: 20px">
        <div v-for="(hashTag, index) in beer.hashTags" :key="index" class="checkbox-wrapper">
          <input type="checkbox" ref="tags" v-model="selectedTags" :id="hashTag.hashTagName" :value="hashTag.hashTagName" />
          <div>
            <span style="padding: 5px"> #{{ hashTag.hashTagName }} </span>
          </div>
        </div>
      </div>
    </el-card>

    <el-row>
      <el-col :span="20">
        <el-input placeholder="직접 입력" v-model="keyword" class="input-with-select" @keyup.enter="addTag(this.keyword)"
      /></el-col>

      <el-col :span="4">
        <el-button style="width: 100%" icon="el-icon-search"></el-button>
      </el-col>
    </el-row>

    <div class="review-select-box">
      <el-scrollbar max-height="200px" v-show="isShow">
        <p class="item" v-for="(hashTag, index) in hashTags" :key="index" @click="addTag(hashTag.hashTagName)">
          #{{ hashTag.hashTagName }}
        </p>
      </el-scrollbar>
    </div>

    <div style="margin-top: 3%">
      <div class="checkbox-wrapper" v-for="(tagName, index) in selectedTags" :key="index">
        <el-button @click="selectedTags.splice(index, 1)">#{{ tagName }}</el-button>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: "ReviewWrite",
  components: {},
  data() {
    return {
      beer: [],
      rating: null,
      hashTags: [],
      selectedTags: [],
      searchTags: [],
      keyword: "",
      isShow: false,
      beerId: "",
    };
  },
  created() {
    this.beerId = this.$route.query.beerId;
  }, 
  mounted() {
    this.getBeerData(this.beerId);
  },
  methods: {
    async getBeerData(id) {
      this.beer = await this.$api("beer?beerId=" + id, "get"); //test API
    },
    async getHashTags() {
      this.hashTags = await this.$api("search/hashtag?keyword=" + this.keyword, "get");
    },
    addTag(name) {
      let flag = false;

      for (let i = 0; i < this.selectedTags.length; i++) {
        if (this.selectedTags[i] == name) {
          flag = true;
          break;
        }
      }
      if (!flag) this.selectedTags.push(name);
    },
    async regist() {
      let reviewHashTags = [];
      this.selectedTags.forEach((element) => {
        reviewHashTags.push({ hashTagName: element });
      });

      let review = {
        userId: sessionStorage.getItem("userId"),
        beerId: this.beerId,
        rating: this.rating,
        hashTags: reviewHashTags,
      };

      await this.$api("review", "post", review);
      this.$router.push("/feed");
    },
  },
  watch: {
    keyword() {
      if (this.keyword == "") this.isShow = false;
      else {
        this.isShow = true;
        this.getHashTags();
      }
    },
  },
};
</script>
<style>
.selected-tag-name {
  margin-right: 1%;
}
.review-select-box {
  box-shadow: 1px 4px 5px 1px #d3d3d3;
  padding-left: 3%;
  margin: 1%;
}
.el-dropdown-link {
  cursor: pointer;
  color: #409eff;
}
.el-icon-arrow-down {
  font-size: 12px;
}
input[type="checkbox"] {
  position: absolute;
  top: 0;
  left: 0;
  width: 140px;
  height: 100px;
  opacity: 0;
  cursor: pointer;
}
input[type="checkbox"]:checked ~ div {
  background-color: black;
  color: white;
  background-clip: content-box;
}
.checkbox-wrapper {
  position: relative;
  float: left;
  border: 1px solid black;
  box-sizing: border-box;
  border-radius: 7%;
  margin-right: 3px;
  background-clip: content-box;
}
.checkbox-wrapper div {
  display: flex;
  justify-content: center;
  align-items: center;
  line-height: 25px;
  transition: 0.5s ease;
}
video {
  display: none;
}
</style>
