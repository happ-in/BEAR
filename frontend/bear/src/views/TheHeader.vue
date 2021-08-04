<template>
<div id="nav">
    <body>
        <div data-role="page">
            <div data-role="header">
                <h3>header</h3>
                <a href="#" data-icon="arrow-l" data-rel="back">이전</a>
            </div>
        </div>
    </body>
</div>
</template>

<script>
    export default {
        name: '', //컴포넌트 이름
        components: {},
        data() { //html과 자바스크립트 코드에서 사용할 데이터 변수 선언
            return {
                sampleData: ''
            };
        },
        setup() {}, //컴포지션 API
        created() {}, //컴포넌트가 생성되면 실행
        mounted() {}, //template에 정의된 html코드가 레너링된 후 실행
        unmounted() {}, //unmount가 완료된 후 실행
        methods: {} //컴포넌트 내에서 사용할 메소드 정의
    }
</script>

<style>
</style>