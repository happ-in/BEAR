<template>
<div>
    <h1>상세페이지</h1>
    <el-carousel indicator-position="outside">
        <el-carousel-item id="beer-detail">
            <img src="#" alt="">
            <h3>{{ item }}</h3>
        </el-carousel-item>
        <el-carousel-item id="beer-snack">
            <h3>{{ item }}</h3>
        </el-carousel-item>
    </el-carousel>
</div>
</template>

<script>
export default {
    name: 'Detail', //컴포넌트 이름
    components: {},
    data() { //html과 자바스크립트 코드에서 사용할 데이터 변수 선언
        return {
            beerData: [],
            snackData: [],
        };
    },
    setup() {}, //컴포지션 API
    created() {
        
    }, //컴포넌트가 생성되면 실행
    mounted() {}, //template에 정의된 html코드가 레너링된 후 실행
    unmounted() {}, //unmount가 완료된 후 실행
    methods: {
        async getBeerData() {
            this.beerData = await this.$api("https://i5a403.p.ssafy.io/rank/beer?beerId="+this.$route.params.beerId,"get");
            console.log(this.rankData);
        },
        async getSnackData() {
            this.snackData = await this.$api("https://i5a403.p.ssafy.io/snack?beerCategory"+this.beerData.beerCategory,"get");
            console.log(this.rankData);
        }
    } //컴포넌트 내에서 사용할 메소드 정의
}
</script>

<style>
    .el-carousel__item h3 {
    color: #475669;
    font-size: 18px;
    opacity: 0.75;
    line-height: 300px;
    margin: 0;
    }

    .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
    }

    .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
    }

</style>