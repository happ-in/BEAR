import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import mixin from "./mixin";
import ElementPlus from "element-plus";

createApp(App).use(store).use(router).mixin(mixin).use(ElementPlus).mount("#app");
// window.Kakao.init("fa7ca4339835a3b0d37662fbf0b78fb8");
