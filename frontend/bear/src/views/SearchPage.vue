<template>
<div id="container">
    <el-input id="search_input"
      class="inline-input"
      v-model="state1"
      @input="submitAutoComplete"
      :fetch-suggestions="querySearch"
      placeholder="태그 또는 맥주를 입력하세요"
      prefix-icon="el-icon-search"
      @select="handleSelect"
      style="width: 309px;"
    ></el-input>
<el-button-group style="margin-top:60px">
  <el-button type="warning" plain style="width:120px" ref="account" @click="setCategory('account')">계정</el-button>
  <el-button type="warning" plain style="width:120px" ref="tag" @click="setCategory('hashtag')">태그</el-button>
  <el-button type="warning" autofocus plain style="width:120px" ref="beer" @click="setCategory('beer')">맥주</el-button>
</el-button-group>
<ul class="infinite-list" v-infinite-scroll="load" style="overflow:auto" v-if="category=='beer'">
    <li v-for="i,index in resultData" class="infinite-list-item" :key="index">{{ i.beerName }}</li>
</ul>
<ul class="infinite-list" v-infinite-scroll="load" style="overflow:auto" v-if="category=='hashtag'">
    <li v-for="i,index in resultData" class="infinite-list-item" :key="index">{{ i.hashTagName }}</li>
</ul>


</div>
</template>

<script>
  import { defineComponent } from 'vue'
export default defineComponent({
    data() {
        return {
            category: 'beer',
            buttontype: 'success',
            resultData: [],
            state1: '',
            count : 0
        }
    },
  methods: {
      async submitAutoComplete() {
        if(this.state1){
          this.resultData = await this.$api("https://i5a403.p.ssafy.io/search/"+this.category+"?keyword="+ this.state1,"get");
        }
          console.log(this.resultData);
      },
      setCategory(data){
        this.category = data;
      },
      load () {
        this.count += 2
      }
  }
});
</script>

<style>
#container {
    position: relative;
    width: 360px;
    height: 640px;

    background: white;
}

#search_input {
    position: absolute;
    width: 309px;
    height: 40px;
    left: 0px;
    top: 0px;
}
img{
  border:none;
}
video{
    display: none;
}
</style>