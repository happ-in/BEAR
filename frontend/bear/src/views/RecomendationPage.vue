<template>
<div class="wrapper">
    <!-- 맥주 이름, 국기 이미지 -->
    <h1 class="Aligner">
        {{ beer.name }} 
        <img class="Aligner-item" :src="beer.countryImg" />
    </h1>
    <!-- 맥주 이미지 -->
    <div class="my-box"><img :src="beer.imgUrl"/></div>
    <!-- 해시태그 -->
    <li id="hashtag" v-for="hashtag in hashtagdata.hashtags" v-bind:key="hashtag">
        <p>{{ hashtag }}</p>
    </li>
    <!-- 버튼 -->
    <div ids="btn">
        <button id="repeatbtn">다시하기</button>
        <button id="detailbtn">상세페이지</button>
    </div>
</div>
</template>

<script>
    export default {
        name: 'Recomandation', //컴포넌트 이름
        components: {},
        data() { //html과 자바스크립트 코드에서 사용할 데이터 변수 선언
            return {
                beer: {name: '시메이 화이트 트리펠', imgUrl: 'https://i1.wp.com/taesanliquor.com/wp-content/uploads/2020/04/Chimay-White-01.png?resize=386%2C512&ssl=1'},
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
.wrapper {
    position: absolute;
    width: 367px;
    height: 649px;
    left: -4px;
    top: -4px;

    background: linear-gradient(180deg, rgba(245, 223, 77, 0) 0%, rgba(245, 223, 77, 0.453125) 21.88%, rgba(245, 223, 77, 0.945675) 36.98%, #F5DF4D 100%);
}
h1 {
    vertical-align:middle;
    position: absolute;
    left: 35px;
    top: 40px;

    font-family: Noto Sans;
    font-style: normal;
    font-weight: normal;
    font-size: 25px;
    line-height: 38px;

    color: #000000;
}
h1 img {
    /* position: absolute; */
    float: right;
    width: 24px;
    height: 15.97px;
    left: 287px;
    /* top: 40px; */

}
/* #countryImg {
    position: absolute;
    width: 24px;
    height: 15.97px;
    left: 287px;
    top: 72px;
} */
.my-box {
    position: absolute;
    width: 291px;
    height: 375px;
    left: 34px;
    top: 104px;

    background: #FFFFFF;
    box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
}
.my-box img
{
  position: absolute;
  top: 20px;
  left: 0;
  width: 100%;
  height: 100%;
  object-fit: cover;
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
}
#hashtag {
    position: absolute;
    list-style: none;
    left: 10.83%;
    right: 57.22%;
    top: 76.88%;
    bottom: 19.69%;

    font-family: Noto Sans;
    font-style: normal;
    font-weight: bold;
    font-size: 20px;
    line-height: 27px;

    color: #FFFFFF;

    border: 1px solid #939597;
}
</style>