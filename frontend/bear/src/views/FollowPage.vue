<template>
  <div style="margin: 3%">
    <h2>{{ $route.params.header }}</h2>
  </div>

  <div style="width: 400px">
    <el-row>
      <el-avatar :size="100" :src="user.userImage" />
      <div class="follow-wrapper">
        <div>뱃지명</div>
        <div class="nickname">{{ user.nickName }}</div>
      </div>
    </el-row>
  </div>
</template>
<script>
export default {
  data() {
    //html과 자바스크립트 코드에서 사용할 데이터 변수 선언
    return {
      radio: "북마크",
      centerDialogVisible: false,
      user: {
        userImage: "https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png",
        customId: "happ-in",
        nickName: "순무엄마동생",
      },
      beer: {
        beerName: "시메이 화이트 트리펠",
        beerImage:
          "https://assets.business.veluga.kr/media/public/Chimay_Chimay_TripelCinq_Cents_4SYlnWG.png",
        countryImg:
          "https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/Flag_of_Belgium.svg/240px-Flag_of_Belgium.svg.png",
        rating: 4.5,
        hashTags: [
          { hashTagName: "트라피스트" },
          { hashTagName: "명품" },
          { hashTagName: "과일향" },
          { hashTagName: "향신료" },
        ],
        totalLike: 10,
        isLike: false,
      },
      isFollow: false,
      src: require("../assets/heart.png"),
    };
  },
  setup() {}, //컴포지션 API
  created() {}, //컴포넌트가 생성되면 실행
  mounted() {}, //template에 정의된 html코드가 레너링된 후 실행
  unmounted() {}, //unmount가 완료된 후 실행
  methods: {},
};
</script>
<style>
video {
  display: none;
}
.nickname {
  font-size: x-large;
  font-weight: bold;
}
.follow-wrapper {
  align-self: center;
  margin-left: 5%;
}
</style>
