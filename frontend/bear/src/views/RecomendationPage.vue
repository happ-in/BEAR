<template>
<div class="wrapper">
    <div>
        <h2>{{ beer.name }}</h2>
        <img class="countryImg" :src="beer.countryImg" />
    </div>
    <img :src="beer.imgUrl" />
    <!-- <div v-for="hashtag in hashtags" :key="beer.name">
        <p>{{ hashtag }}</p>
    </div> -->
    <div class="btn">
        <button class="repeat">다시하기</button>
        <button>상세페이지</button>
    </div>
</div>
</template>

<script>
    export default {
        name: 'Recomandation', //컴포넌트 이름
        components: {},
        data() { //html과 자바스크립트 코드에서 사용할 데이터 변수 선언
            return {
                beer: {name: '시메이 화이트 트리펠', imgUrl: 'http://i.imgur.com/Fqclzke.jpg', countryImg: 'https://mblogthumb-phinf.pstatic.net/MjAxODA2MTlfMTcw/MDAxNTI5MzU5OTQzNzE4.7KrwpTuixeXhZHpQwkTsRikjN_JzQFHgrGfaeVBCfZIg.V5ko09Oyooy91gfNpyHcWedcnRC_LXTwvgxmvAvcgQwg.PNG.ahn3607/20af8eb0aa8d6e65c536f7223799bfc51b725e5462495a7b3483df43aa8d324c3f8c8f2b0aef1a9f7422f81d675d18fe288d342bfdbbf1f84e9b11f47b437a22088f720ae5ae84bd89df086340a4f72d.png?type=w2', hashtags: '#트리플'},
                hashtag: {beerid: '', hashtags: ''}
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
.repeat {
    position: absolute;
    width: 138px;
    height: 43px;
    left: 42px;
    top: 570px;

    background: #FFFFFF;
    border: 1px solid #939597;
    box-sizing: border-box;
}
.countryImg {
    position: absolute;
    width: 24px;
    height: 15.97px;
    left: 287px;
    top: 72px;
}
</style>