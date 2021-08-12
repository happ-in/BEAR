<template>
  <h2>{{ user.customId }}</h2>
  <el-container class="mb-4" style="margin-top: 5%">
    <!-- 프로필 이미지 -->
    <el-aside width="200px">
      <div class="block profile-image">
        <el-avatar
          :src="user.userImage"
          :size="100"
          @error="errorHandler"
          style="margin-right: 4px"
        />
      </div>
    </el-aside>

    <!-- 뱃지, 닉네임 -->
    <el-main>
      <div>뱃지명</div>
      <div>{{ user.nickName }}</div>
    </el-main>
  </el-container>

  <!-- 리뷰수/팔로잉/팔로워 -->
  <el-row>
    <el-col :span="8">
      <div class="grid-content bg-purple">리뷰수</div>
      <div class="grid-content bg-purple">00</div>
    </el-col>
    <el-col :span="8">
      <div class="grid-content bg-purple-light">팔로잉</div>
      <div class="grid-content bg-purple-light">00</div>
    </el-col>
    <el-col :span="8">
      <div class="grid-content bg-purple">팔로워</div>
      <div class="grid-content bg-purple">00</div>
    </el-col>
  </el-row>

  <!-- 팔로우/팔로우 취소 -->
  <el-row>
    <el-button plain style="width: 100%; margin: 3%"> 프로필 변경 </el-button>
  </el-row>

  <div style="width: 100%">
    <el-tabs type="card">
      <!-- 북마크 -->
      <el-tab-pane label="북마크">
        <el-row>
          <el-col :span="8" v-for="(o, index) in 2" :key="o" :offset="index > 0 ? 2 : 0">
            <el-card>
              <img :src="beer.beerImage" height="200" />
              <div>
                <span>{{ beer.beerName }}</span>
              </div>
            </el-card>
          </el-col>
        </el-row>
      </el-tab-pane>

      <!-- 리뷰 -->
      <el-tab-pane label="리뷰">
        <div>
          <el-card class="box-card">
            <!-- 맥주이미지 -->
            <el-row>
              <el-col :span="7"
                ><img :src="beer.beerImage" class="grid-content bg-purple" style="width: 100%" />
              </el-col>

              <!-- 제목, 별점, 해시태그 -->
              <el-col :span="14">
                <el-row :gutter="20">
                  <span>
                    {{ beer.beerName }}
                    <img :src="beer.countryImg" style="width: 6%" />
                  </span>
                  <el-rate v-model="beer.rating" allow-half disabled></el-rate>
                </el-row>

                <div style="position: relative; top: 20px">
                  <el-tag
                    type="info"
                    v-for="(hashTag, index) in beer.hashTags"
                    :key="index"
                    style="margin-right: 1%; margin-bottom: 1%"
                  >
                    # {{ hashTag.hashTagName }}
                  </el-tag>
                </div>
              </el-col>

              <!-- 하트 -->
              <el-col :span="3">
                <div class="heart-wrapper">
                  <div class="heart-image">
                    <img :src="src" />
                  </div>
                  <div class="heart-text">
                    <button @click="isLikeFeed" :class="{ likeFeed: beer.isLike }">
                      {{ beer.totalLike }}
                    </button>
                  </div>
                </div>
                <div>
                  <div
                    class="heart-wrapper"
                    style="width: 60%; margin-top: 120%; text-align: center"
                  >
                    <img src="../assets/more.png" class="image" />
                  </div>
                </div>
              </el-col>
            </el-row>
          </el-card>
        </div>
      </el-tab-pane>

      <!-- 뱃지 -->
      <el-tab-pane label="뱃지">
        <el-row>
          <el-col :span="8" style="text-align: center">
            <img src="../assets/logo.png" width="120" /> <br />
            <el-button type="text" @click="centerDialogVisible = true"> 콜럼버스 </el-button>
            <el-dialog title="뱃지 타이틀" v-model="centerDialogVisible" width="50%" center>
              <div style="text-align: center">
                <img src="../assets/logo.png" width="120" /> <br />
                <h4>21.08.13 획득</h4>
                <span>뱃지 설명</span>
              </div>
            </el-dialog>
          </el-col>
          <el-col :span="8"></el-col>
          <el-col :span="8"></el-col>
        </el-row>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>
<script>
export default {
  name: "UserFollow", //컴포넌트 이름
  components: {},
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
  methods: {
    isLikeFeed() {
      this.beer.isLike = !this.beer.isLike;
      if (this.beer.isLike) {
        this.beer.totalLike += 1;
        this.src = require("../assets/redHeart.png");
      } else {
        this.beer.totalLike -= 1;
        this.src = require("../assets/heart.png");
      }
    }, //컴포넌트 내에서 사용할 메소드 정의
  },
};
</script>
<style>
.profile-image {
  margin-left: 30%;
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
button {
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
</style>
