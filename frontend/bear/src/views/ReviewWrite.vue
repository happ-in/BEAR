<template>
  <div>
    <div style="display: flex">
      <h2>리뷰</h2>
      <el-button round>등록</el-button>
    </div>
    <el-card class="box-card">
      <div style="display: flex">
        <h1>'{{ beer.beerName }}'</h1>
        <h4>어떠셨나요?</h4>
      </div>

      <div style="text-align: center">
        <p>별표를 드래그하세요.</p>
        <el-rate v-model="rating" allow-half />
      </div>

      <div style="margin-top: 20px">
        <div v-for="(hashTag, index) in beer.hashTags" :key="index" class="checkbox-wrapper">
          <input
            type="checkbox"
            ref="tags"
            v-model="tagNames"
            :id="hashTag.hashTagName"
            :value="hashTag.hashTagName"
          />
          <div>
            <span style="padding: 5px"> #{{ hashTag.hashTagName }} </span>
          </div>
        </div>
      </div>
    </el-card>

    <el-row style="margin: 3px">
      <el-col :span="20"
        ><el-input placeholder="직접 입력" v-model="keyword" class="input-with-select"
      /></el-col>
      <el-col :span="4"><el-button icon="el-icon-search"></el-button></el-col>
    </el-row>

    <div class="tag-name" v-for="(tagName, index) in tagNames" :key="index">
      <el-button @click="cancel(index)">#{{ tagName }}</el-button>
    </div>
  </div>
</template>
<script>
export default {
  name: "ReviewWrite", //컴포넌트 이름
  components: {},
  data() {
    //html과 자바스크립트 코드에서 사용할 데이터 변수 선언
    return {
      beer: {
        beerName: "시메이 화이트 트리펠",
        beerImage:
          "https://assets.business.veluga.kr/media/public/Chimay_Chimay_TripelCinq_Cents_4SYlnWG.png",
        countryImg:
          "https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/Flag_of_Belgium.svg/240px-Flag_of_Belgium.svg.png",
        hashTags: [
          { hashTagName: "트라피스트" },
          { hashTagName: "명품" },
          { hashTagName: "과일향" },
          { hashTagName: "향신료" },
        ],
        totalLike: 10,
        isLike: false,
      },
      rating: null,
      hashTags: [],
      tagNames: [],
      keyword: "",
    };
  },
  setup() {}, //컴포지션 API
  created() {}, //컴포넌트가 생성되면 실행
  mounted() {}, //template에 정의된 html코드가 레너링된 후 실행
  unmounted() {}, //unmount가 완료된 후 실행
  methods: {
    cancel(index) {
      this.beer.hashTags.forEach((element) => {
        if (element.hashTagName == this.tagNames[index]) {
          this.tagNames.pop(this.tagNames[index]);
        }
      });
    },
  },
};
</script>
<style>
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
</style>
