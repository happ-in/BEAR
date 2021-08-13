import { createRouter, createWebHistory } from "vue-router";
// import Home from "../views/Home.vue";
import Recommendation from "../views/RecommendationPage.vue";
import RankingMain from "../views/RankingMainPage.vue";
import Landing from "../views/LandingPage.vue";
import RankingCategory from "../views/RankingCategoryPage.vue";
import FollowPage from "../views/FollowPage.vue";
import Detail from "../views/DetailPage.vue"

const routes = [
  {
    path: "/",
    name: "Landing",
    component: Landing,
  },
  // {
  //   path: "/",
  //   name: "Home",
  //   component: Home,
  // },
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
  {
    path: "/profile",
    name: "UserProfile",
    component: () => import(/* webpackChunkName: "about" */ "../views/UserProfilePage.vue"),
  },
  {
    path: "/myprofile",
    name: "MyProfile",
    component: () => import(/* webpackChunkName: "about" */ "../views/MyProfilePage.vue"),
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
  {
    path: "/follow",
    name: "Follow",
    component: FollowPage,
  },
  {
    path: "/detail/:beerId",
    name: "Detail",
    component: Detail,
  }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
