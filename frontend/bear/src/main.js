import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import ElementPlus from 'element-plus';


createApp(App).use(store).use(router).use(ElementPlus).mount("#app");  


// import RankingMain from './views/RankingMainPage.vue'
// import RankingCategory from ''