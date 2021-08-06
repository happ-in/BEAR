<template>
    <div id="nav">
        <div data-role="page">
            <div class="container">
                <button @click="goBack" type="button"><img id="backIcon" src="../assets/navigation_arrow_left_back_icon.png" /></button>
                <h3>{{ pageName }}</h3>
            </div>
        </div>
    </div>
</template>
<script>

    export default {
        name: 'Header', //컴포넌트 이름
        components: {},
        data() { //html과 자바스크립트 코드에서 사용할 데이터 변수 선언
            return {
                 links: [
                    {
                        id: 0,
                        text: "메인으로",
                        page: "/"
                    },
                    {
                        id: 1,
                        text: "First로 가기",
                        page: "/first"
                    }
                ],
            };
        },
        setup() {}, //컴포지션 API
        created() {
            
        }, //컴포넌트가 생성되면 실행
        mounted() {}, //template에 정의된 html코드가 레너링된 후 실행
        unmounted() {}, //unmount가 완료된 후 실행
        methods: {
            goBack(){
                this.$router.go(-1); [2]
            },
            getPageName() {
                var pageName = "";
            
                var tempPageName = window.location.href;
                console.log(tempPageName)
                var strPageName = tempPageName.split("/");
                pageName = strPageName[strPageName.length-1].split("?")[0];
            
                return pageName;
            },
        } //컴포넌트 내에서 사용할 메소드 정의
    }
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500&display=swap');

#app {
  font-family: 'Noto Sans KR', sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: black;
}

.container {
  display: flex;
}

#backIcon {
  width: 7vw;
  height: 7vw;
  vertical-align: middle;
  margin-right: auto;
}

h3 {
  align-items: center;
  margin: 0 auto;

}
</style>