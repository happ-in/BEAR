import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import mixin from "./mixin"

createApp(App).use(store).use(router).mixin(mixin).mount("#app");
