<template>
  <div class="edit-wrap">
    <el-row>
      <el-col :span="6"> </el-col>
      <el-col :span="12">
        <div class="header">프로필 수정</div>
      </el-col>
      <el-col :span="6">
        <el-button round style="padding: 8px 16px; float: right" @click="updateUser">수정</el-button>
      </el-col>
    </el-row>

    <hr />

    <div style="text-align: center">
      <img class="edit-round-image" :src="user.userImage" alt="" />
    </div>

    <div class="edit-logout">
      <el-button @click="logout">로그아웃</el-button>
    </div>

    <el-row class="edit-float-center">
      <el-col :span="4">아이디</el-col>
      <el-col :span="20"><input class="edit-input" :placeholder="아이디" v-model="customId" /> </el-col>
    </el-row>

    <el-row class="edit-float-center">
      <el-col :span="4">닉네임</el-col>
      <el-col :span="20"><input class="edit-input" :placeholder="닉네임" v-model="nickname" /> </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "profileEdit",
  components: {},
  data() {
    return {
      user: [],
      customId: "",
      nickname: "",
    };
  },
  created() {
    this.getUser();
  }, 
  methods: {
    async getUser() {
      this.user = await this.$api("search/userInfo?userId=" + sessionStorage.getItem("userId"), "get");
      this.customId = this.user.customId;
      this.nickname = this.user.nickname;
    },
    async updateUser() {
      let data = {
        customId: this.customId,
        nickname: this.nickname,
        userId: sessionStorage.getItem("userId"),
      };
      let flag = await this.$api("user/update", "put", data);
      if (flag) this.$router.push("/myprofile");
      else alert("중복된 아이디입니다.");
    },
    logout() {
      sessionStorage.clear();
      this.$router.push("/login");
    },
  },
};
</script>

<style>
.edit-float-center {
  align-items: center;
}
.edit-round-image {
  width: 120px;
  height: 120px;
  border-radius: 70%;
  object-fit: contain;
}
.edit-input {
  width: 91%;
  padding: 3%;
  border-top: none;
  border-left: none;
  border-right: none;
  margin: 2%;
  border-bottom: 0.7px solid #b3b3b3;
}
.edit-logout {
  text-align: center;
  margin: 3%;
}
</style>
