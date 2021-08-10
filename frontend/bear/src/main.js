import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import mixin from "./mixin"
import ElementPlus from 'element-plus';

createApp(App).use(store).use(router).mixin(mixin).use(ElementPlus).mount("#app");


