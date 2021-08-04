import BootstrapVue from 'bootstrap-vue'
import Vue, { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";

Vue.use(BootstrapVue)
createApp(App).use(store).use(router).mount("#app");
