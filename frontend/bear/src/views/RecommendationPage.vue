<template>
<div class="wrapper">
    <!-- 맥주 이름, 국기 이미지 -->
    <div class="card">
        <h1 style="display: flex; justify-content: space-around;">
            {{ beer.name }} 
            <img :src="beer.countryImg" />
        </h1>
        <!-- 맥주 이미지 -->
        <div class="beerimg-box"><img :src="beer.imgUrl"/></div>
    
        <!-- 해시태그 -->
        <ul class="hashtag">
            <li  v-for="hashtag in hashtagdata.hashtags" v-bind:key="hashtag.id">
                <p>{{ hashtag }}</p>
            </li>
        </ul>
    </div>
    <!-- 버튼 -->
    <div id="btn">
        <a href="#" class="button" id="repeatbtn">
            <svg fill="none" xmlns="http://www.w3.org/2000/svg"><path d="M8 4V0L3 5l5 5V6a6 6 0 11-6 6H0a8 8 0 108-8z" fill="#939597"/></svg>
            다시하기
        </a>
        <a href="#" class="button" id="detailbtn">상세페이지</a>
    </div>
</div>
</template>

<script>
    export default {
        name: 'Recommendation', //컴포넌트 이름
        components: {},
        data() { //html과 자바스크립트 코드에서 사용할 데이터 변수 선언
            return {
                beer: {name: '시메이 화이트 트리펠', imgUrl: 'https://assets.business.veluga.kr/media/public/Chimay_Chimay_TripelCinq_Cents_4SYlnWG.png', countryImg: 'https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/Flag_of_Belgium.svg/240px-Flag_of_Belgium.svg.png', },
                hashtagdata: {hashtags: ['#트라피스트', '#향신료', '#과일향', '#명품']}
            };
        },
        setup() {}, //컴포지션 API
        created() {}, //컴포넌트가 생성되면 실행
        mounted() {}, //template에 정의된 html코드가 레너링된 후 실행
        unmounted() {}, //unmount가 완료된 후 실행
        methods: {}, //컴포넌트 내에서 사용할 메소드 정의
    }
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300;400;500;700&display=swap');

/* 다시하기랑 상세페이지 중간으로/ 글자 간격 띄우고 싶다  */
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400&display=swap');
.wrapper {
    position: absolute;
    width: 367vw;
    height: 190vw;
    left: -4px;
    top: -4px;

    font-family: 'Noto Sans KR', sans-serif;
    background: linear-gradient(180deg, rgba(245, 223, 77, 0) 0%, rgba(245, 223, 77, 0.453125) 21.88%, rgba(245, 223, 77, 0.945675) 36.98%, #F5DF4D 100%);
}
.card {
    margin-top: 48px;
    margin-left: 35px;
    display: flex;
    flex-direction: column;
    width: 291px;
}
h1 {
    /* vertical-align:middle; */
    /* position: absolute; */
    /* left: 35px;
    top: 40px; */
    /* width: 100%; */

    margin-bottom: 4px;
    font-family: 'Noto Sans KR', sans-serif;
    font-style: normal;
    font-weight: 400;
    font-size: 25px;
    /* line-height: 38px; */

    color: #000000;
}
h1 img {
    position: inline;
    /* vertical-align: middle; */
    align-self: center;
    /* display: flex; */
    
    /* padding-bottom: 10px; */
    width: 24px;
    height: 15.97px;
    bottom: 10px;
}
.beerimg-box {
    position: relative;
    width: 291px;
    height: 375px;
    /* left: 34px;
    top: 104px; */

    background: #FFFFFF;
    box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
}
.beerimg-box img
{
  position: absolute;
  top: 20px;
  left: 0;
  width: 100%;
  height: 100%;
  object-fit: contain;
}
#repeatbtn {
    position: absolute;
    width: 138px;
    height: 43px;
    left: 42px;
    top: 570px;

    background: #FFFFFF;
    border: 1px solid #939597;
    box-sizing: border-box;

    text-decoration: none;

    font-family: 'Noto Sans KR', sans-serif;
    font-style: normal;
    font-weight: bold;
    font-size: 15px;
    line-height: 40px;
    
    color: #939597;
}
#repeatbtn svg {
    padding-top: 10px;
    width: 16px;
    height: 20px;
}
#detailbtn {
    position: absolute;
    width: 138px;
    height: 43px;
    left: 180px;
    top: 570px;

    background: #939597;
    border: 1px solid #939597;
    box-sizing: border-box;

    text-decoration: none;

    font-family: 'Noto Sans KR', sans-serif;
    font-style: normal;
    font-weight: bold;
    font-size: 15px;
    line-height: 38px;
    color: white;
}
.hashtag {
    list-style: none;
    top: 73%;
    width: 280px;
    padding-left: 2vw;
    /* left: 10.83%;
    right: 57.22%;
    top: 76.88%;
    bottom: 19.69%; */

    columns: 2;
    -webkit-columns: 2;
    -moz-columns: 2;

    color: #FFFFFF;

}
.hashtag li {
    width: 140px;
}
.hashtag p {
    position: relative;
    margin: 0px;
    width: 140px;

    text-align: left;
    text-shadow: -1px 0 #939597, 0 1px #939597, 1px 0 #939597, 0 -1px #939597;
    font-family: 'Noto Sans KR', sans-serif;
    font-style: normal;
    font-weight: bold;
    font-size: 20px;

    color: #FFFFFF;
}
</style>