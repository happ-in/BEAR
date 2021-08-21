<template>
<div class="follow-wrap">
  <div style="margin: 3%">
    <div class="header">{{ $route.params.header }}</div>
  </div>

  <div style="width: 100%; padding: 2%" v-for="(other, index) in others" :key="index">
    <el-row>
      <el-avatar :size="80" :src="other.userImage" />
      <div class="follow-wrapper">
        <div class="nickname">{{ other.customId }}</div>
        <div>{{ other.nickname }}</div>
      </div>
    </el-row>
  </div>
</div>
</template>
<script>
export default {
  data() {
    //html과 자바스크립트 코드에서 사용할 데이터 변수 선언
    return {
      radio: "북마크",
      centerDialogVisible: false,
      others: [],
    };
  },
  setup() {}, //컴포지션 API
  created() {
    this.getOthers();
  }, //컴포넌트가 생성되면 실행
  mounted() {}, //template에 정의된 html코드가 레너링된 후 실행
  unmounted() {}, //unmount가 완료된 후 실행
  methods: {
    async getOthers() {
      if ("팔로잉" == this.$route.params.header) {
        this.others = await this.$api("search/follows?userId=" + this.$route.params.userId);
      } else {
        this.others = await this.$api("search/followers?userId=" + this.$route.params.userId);
      }
    },
  },
};
</script>
<style>
video {
  display: none;
}
.nickname {
  font-size: x-large;
  font-weight: bold;
  margin-bottom: 5%;
}
.follow-wrapper {
  align-self: center;
  margin-left: 5%;
}
</style>
