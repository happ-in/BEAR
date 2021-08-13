<template>
  <div class="wrapper-rank-category">
    <h1>{{this.$route.params.category}}</h1>
    <!-- countryName, beerCategory, alcoholProof 도 추가-->
    <li id="ranking-box-list" v-for="(beer, index) in rankData" v-bind:key="index" >
        <el-card class="box-card" @click="pushBeerId(index)">
            <h2>{{index+1}}위</h2>
            <img src="#" alt="beerimg">
            <div>
                <h2>{{beer.beerName}}</h2>
                <p>{{beer.countryName}}/{{beer.beerCategory}}/{{beer.alcoholProof}}</p>
                <div>{{beer.beerCategory}}{{index+1}}위</div>
                <div>{{beer.totalCount}}명이 좋아해요!</div>
            </div>
        </el-card>
    </li>
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
            rankData: [],
        }
    },
    setup() {}, //컴포지션 API
    created() {


    }, //컴포넌트가 생성되면 실행
    mounted() {
        this.getRankData()
    }, //template에 정의된 html코드가 레너링된 후 실행
    unmounted() {}, //unmount가 완료된 후 실행
    methods: {
        pushBeerId(index) {
            this.$router.push({
                name: "Detail",
                params: { beerId: this.rankData[index].beerId },
            });
            console.log(this.rankData[index])
        },
        async getRankData() {
            this.rankData = await this.$api("https://i5a403.p.ssafy.io/rank/"+this.$route.params.category,"get");
            console.log(this.rankData);
        }
    }, //컴포넌트 내에서 사용할 메소드 정의
};
</script>


<style>
video{
    display: none;
    }
.text {
font-size: 14px;
}

.item {
padding: 18px 0;
}
#ranking-box-list {
    list-style:none;
    
}
.box-card {
    display:flex;
    margin: 7px;
    width: 90vw;
    padding: 5px;
}
.el-card__body {
    display: flex;
    /* flex-direction: row; */
    justify-content: center;
}
.box-card h2 {
}
.box-card img {

}
#beerInfo {
    display: flex;
    flex-direction: row
}
</style>
