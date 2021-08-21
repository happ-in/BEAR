import { createRouter, createWebHistory } from "vue-router";
// import Home from "../views/Home.vue";
import Recommendation from "../views/RecommendationPage.vue";
import RankingMain from "../views/RankingMainPage.vue";
import Landing from "../views/LandingPage.vue";
import RankingCategory from "../views/RankingCategoryPage.vue";
import FollowPage from "../views/FollowPage.vue";
import Detail from "../views/DetailPage.vue";
import TagList from "../views/TagListPage.vue";
import ProfileEdit from "../views/ProfileEditPage.vue";
//import store from '../store/index';

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
    beforeEnter: (to, from, next) => {
      if (sessionStorage.getItem("token") !== null) {
        next();
      }
      next("/login");
    },
  },
  {
    path: "/feed",
    name: "Feed",
    component: () => import(/* webpackChunkName: "about" */ "../views/FeedPage.vue"),
    beforeEnter: (to, from, next) => {
      if (sessionStorage.getItem("token") !== null) {
        next();
      }
      next("/login");
    },
  },
  {
    path: "/review/write",
    name: "ReviewWrite",
    component: () => import(/* webpackChunkName: "about" */ "../views/ReviewWrite.vue"),
    beforeEnter: (to, from, next) => {
      if (sessionStorage.getItem("token") !== null) {
        next();
      }
      next("/login");
    },
    //beforeEnter: requireAuth() //똑같은 방식으로 여러개 설정가능
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
    beforeEnter: (to, from, next) => {
      if (sessionStorage.getItem("token") !== null) {
        next();
      }
      next("/login");
    },
  },
  {
    path: "/profileedit",
    name: "ProfileEdit",
    component: ProfileEdit,
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
  },
  {
    path: "/tag",
    name: "TagList",
    component: TagList,
  },
];

// const requireAuth = () => (to, from, next) => {

// }

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
