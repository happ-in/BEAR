<template>
<div class="edit-wrap">
    <h1>프로필 수정</h1>
    <hr>
    <div class="w-32 h-32 border-2 border-dotted border-blue-500">
        <div v-if="images"
            class="w-full h-full flex items-center">
            <img :src="images" alt="image">
        </div>
        <div v-else
            class="w-full h-full flex items-center justify-center cursor-pointer hover:bg-pink-100"
            @click="clickInputTag()">
            <input ref="image" id="input"
                    type="file" name="image" accept="image/*" multiple="multiple"
                    class="hidden"
                    @change="uploadImage()">
            <svg class="w-8 h-8" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 9v3m0 0v3m0-3h3m-3 0H9m12 0a9 9 0 11-18 0 9 9 0 0118 0z" />
            </svg>
        </div>
    </div>
</div>
</template>

<script>
import axios from 'axios'
export default {
    name: 'profileEdit', //컴포넌트 이름
    components: {},
    data() { //html과 자바스크립트 코드에서 사용할 데이터 변수 선언
        return {
            images: ''
        };
    },
    setup() {}, //컴포지션 API
    created() {}, //컴포넌트가 생성되면 실행
    mounted() {}, //template에 정의된 html코드가 레너링된 후 실행
    unmounted() {}, //unmount가 완료된 후 실행
    methods: {
        uploadImage: function() {
            let form = new FormData()
            let image = this.$refs['image'].files[0]
            
            form.append('image', image)
        
            axios.post('/upload', form, {
                header: { 'Content-Type': 'multipart/form-data' }
            }).then( ({data}) => {
                this.images = data
            })
            .catch( err => console.log(err))
        },
        clickInputTag: function() {
            this.$refs['image'].click()
        }
    } //컴포넌트 내에서 사용할 메소드 정의
}
</script>

<style>
</style>