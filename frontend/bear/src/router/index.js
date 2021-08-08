import { createRouter, createWebHistory } from "vue-router";
import Recommendation from "../views/RecommendationPage.vue";

const routes = [
  {
    path: "/recommendation",
    name: "Recommendation",
    component: Recommendation,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
