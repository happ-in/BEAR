import { createRouter, createWebHistory } from "vue-router";
// import Home from "../views/Home.vue";
import Recommendation from "../views/RecommendationPage.vue";
// import RankingMain from "../views/RankingMainPage.vue";
import RankingCategory from "../views/RankingCategoryPage.vue";

const routes = [
  // {
  //   path: "/",
  //   name: "Home",
  //   component: Home,
  // },
  {
    path: "/ar",
    name: "Ar",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/ArPage.vue"),
  },
  {
    path: "/recommendation",
    name: "Recommendation",
    component: Recommendation,
  },
  {
    path: "/ranking",
    name: "RankingMain",
    component: RankingMain,
  },
  {
    path: "/ranking/:category",
    name: "RankingCategory",
    component: RankingCategory,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
