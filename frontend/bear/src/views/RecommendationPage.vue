<template>
<div class="wrapper">
    <div>
        <h2>{{ beer.name }}</h2>
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
</style>