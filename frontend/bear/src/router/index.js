import { createRouter, createWebHistory } from "vue-router";
// import Home from "../views/Home.vue";
import Recommendation from "../views/RecommendationPage.vue";
// import RankingMain from "../views/RankingMainPage.vue";
import Landing from "../views/LandingPage.vue";

const routes = [
  {
    path: "/",
    name: "Landing",
    component: Landing,
  },
  {
    path: "/ar",
    name: "Ar",
    component: () => import(/* webpackChunkName: "about" */ "../views/ArPage.vue"),
  },
  {
    path: "/recommendation",
    name: "Recommendation",
    component: Recommendation,
  },
  {
    path: "/search",
    name: "Search",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ "../views/SearchPage.vue"),
  },
  {
    path: "/feed",
    name: "Feed",
    component: () => import(/* webpackChunkName: "about" */ "../views/FeedPage.vue"),
  },
  {
    path: "/review/write",
    name: "ReviewWrite",
    component: () => import(/* webpackChunkName: "about" */ "../views/ReviewWrite.vue"),
  },
  {
    path: "/login",
    name: "KakaoLogin",
    component: () => import(/* webpackChunkName: "about" */ "../views/LoginPage.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
