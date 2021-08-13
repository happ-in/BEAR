<template>
  <div class="wrapper-rank-category">
    <ul>
    <!-- countryName, beerCategory, alcoholProof 도 추가-->
    <li v-for="beerName in rankData" v-bind:key="beerName">
            <el-card class="box-card" style="display:flex; ">
                <div>1위</div>
                <div><img src="#" alt="beerimg"></div>
                <div>
                    <div id="beerInfo">
                        <h2>{{rankData.beerName}}</h2>
                        <p>{{rankData.countryName}}/{{rankData.beerCategory}}/{{rankData.alcoholProof}}</p>
                        <div>{{rankData.beerCategory}}1위</div>
                    </div>
                    <div>{{rankData.totalCount}}명이 좋아해요!</div>
                </div>
            </el-card>
        </li>
    </ul>
  </div>
</template>

<script>
// import axios from 'axios';

export default {
  name: "RankingCategory", //컴포넌트 이름
  components: {},
  data() {
    //html과 자바스크립트 코드에서 사용할 데이터 변수 선언
    return {
      // category: this.$route.params.category,
    rankData: {
        beerId: '',
        beerName: '',
        countryName: '',
        beerCategory: '',
        alcoholProof: '',
        totalCount: '',
      },
    //   rankData: {
    //       beerId: '',
    //       beerName: '',
    //       countryName: '',
    //       beerCategory: '',
    //       alcoholProof: '',
    //       totalCount: '',
    //   },
    };
  },
  setup() {}, //컴포지션 API
  created() {
    // axios.get('/rank'+category)
    //     .then(res => {
    //         console.log(res.data)
    //     })
  }, //컴포넌트가 생성되면 실행
  mounted() {}, //template에 정의된 html코드가 레너링된 후 실행
  unmounted() {}, //unmount가 완료된 후 실행
  methods: {}, //컴포넌트 내에서 사용할 메소드 정의
};
</script>

<style>
video{
    display: none;
    }
</style>
