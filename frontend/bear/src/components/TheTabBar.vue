<template>
    <div id="tab-wrap">
        <ul id="menu">
            <router-link
            v-for="list in lists"
            :key="list.key"
            :to="list.link"
            tag="li"
            class="tabbar-menu-list"
            class-activate="active"
            exact>{{list.title}}
            </router-link>
        </ul>
    </div>
</template>

<script>
    export default {
        name: 'TabBar', //컴포넌트 이름
        components: {},
        data() { //html과 자바스크립트 코드에서 사용할 데이터 변수 선언
            return {
                 lists: [
                     {link: '/recommendation', title: '랜덤 추천'},
                     {link: '/rank', title:'랭킹'},
                     {link: '/', title:'홈피드'},
                     {link: '/search', title:'검색'},
                     {link: '/myprofile', title:'마이페이지'},
                     {link: '/ar', title:'AR'}
                 ]
            };
        },
        setup() {}, //컴포지션 API
        created() {
            
        }, //컴포넌트가 생성되면 실행
        mounted() {
        }, //template에 정의된 html코드가 레너링된 후 실행
        unmounted() {}, //unmount가 완료된 후 실행
        methods: {
            goBack(){
                this.$router.go(-1); [2]
            },
        } //컴포넌트 내에서 사용할 메소드 정의
    }
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');

#tab-wrap {
    position: fixed;
    left: 0;
    bottom: 0;
    width: 100%;
    height: 10vw;

    display: flex;
    justify-content: space-around;
}
#menu {
    padding: 0;
    /* text-align: center; */

    font-family: 'Noto Sans KR', sans-serif;
    /* text-decoration: none; */
}
.tabbar-menu-list {
    padding: 0 3vw;
}
</style>
