<template>
<div id="container">
  <el-row class="demo-autocomplete" id="search_input" style="border-radius:50px">
  <el-col :span="20">
    <el-autocomplete
      class="inline-input"
      v-model="state1"
      @input="submitAutoComplete"
      :fetch-suggestions="querySearch"
      placeholder="태그 또는 맥주를 입력하세요"
      prefix-icon="el-icon-search"
      @select="handleSelect"
      style="width: 309px;"
    ></el-autocomplete>
  </el-col>
</el-row>
</div>
</template>

<script>
  import { defineComponent, ref, onMounted } from 'vue'
export default defineComponent({
  setup() {
    const restaurants = ref([]);
    const querySearch = (queryString, cb) => {
      var results = queryString
        ? restaurants.value.filter(createFilter(queryString))
        : restaurants.value;
        // call callback function to return suggestions
        cb(results);
    };
    const createFilter = (queryString) => {
      return (restaurant) => {
        return (
          restaurant.value.toLowerCase().indexOf(queryString.toLowerCase()) ===
          0
        );
      };
    };
    const loadAll = () => {
      return [
        { "value": "뷰", "link": "https://github.com/vuejs/vue" },
        { "value": "element", "link": "https://github.com/ElemeFE/element" },
        { "value": "cooking", "link": "https://github.com/ElemeFE/cooking" },
        { "value": "mint-ui", "link": "https://github.com/ElemeFE/mint-ui" },
        { "value": "vuex", "link": "https://github.com/vuejs/vuex" },
        { "value": "vue-router", "link": "https://github.com/vuejs/vue-router" },
        { "value": "babel", "link": "https://github.com/babel/babel" }
        ];
    };
    const handleSelect = (item) => {
      console.log(item);
    };
    onMounted(() => {
      restaurants.value = loadAll();
    });
    return {
      restaurants,
      state1: ref(''),
      querySearch,
      createFilter,
      loadAll,
      handleSelect,
    };
  },
  methods: {
      async submitAutoComplete() {
          this.restaurants.value = await this.$api("localhost:8080/search/beer?keyword="+ this.state1,"get");
      }
  }
});
</script>

<style>
#container {
    position: relative;
    width: 360px;
    height: 640px;

    background: #939597;
}

#search_input {
    position: absolute;
    width: 309px;
    height: 40px;
    left: 0px;
    top: 0px;
    border-radius: 50px;
    margin-top: 20px;
    margin-left: 40px;
}

</style>