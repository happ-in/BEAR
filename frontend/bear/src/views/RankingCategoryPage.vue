<template>
<div class="wrapper">
    <ul>
        <!-- countryName, beerCategory, alcoholProof 도 추가-->
        <li v-for="beerName in category" v-bind:key="beerName">
            <el-card class="box-card">
            <template #header>
                <div class="card-header">
                <span>Card name</span>
                <el-button class="button" type="text">Operation button</el-button>
                </div>
            </template>
            <div v-for="o in 4" :key="o" class="text item">
                {{'List item ' + o }}
            </div>
            </el-card>
        </li>
    </ul>

</div>

</template>
<script>
    export default {
        name: '', //컴포넌트 이름
        components: {},
        data() { //html과 자바스크립트 코드에서 사용할 데이터 변수 선언
            return {
                category:{
                    ranking
                }
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
.wrapper {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}
</style>