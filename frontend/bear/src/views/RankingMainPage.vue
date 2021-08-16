<template>
  <div id="ranking-wrapper">
    <div>
      <h1 class="ranking-title">Ranking</h1>
    </div>
    <div>
      <div class="swiper-container">
        <div class="swiper-wrapper">
          <!-- 전체 -->
          <div class="swiper-slide">
            <button class="slide-image" type="submit" name="all" @click="pushRankCategory($event)">
              <img src="http://res.heraldm.com/phpwas/restmb_idxmake.php?idx=999&simg=%2Fcontent%2Fimage%2F2018%2F06%2F27%2F20180627000547_0.jpg"
                alt="all"
              />
            </button>
          </div>

          <!-- 라거 -->
          <div class="swiper-slide">
            <button class="slide-image" type="submit" name="lager" @click="pushRankCategory($event)">
              <img
                src="https://previews.123rf.com/images/vclements/vclements1002/vclements100200018/6410721-%EB%A7%A5%EC%A3%BC-%EB%A8%B8%EA%B7%B8%EC%9E%94%EC%9D%98-%EC%86%90%EC%9E%A1%EC%9D%B4%EC%97%90-%EC%88%98%EA%B0%91%EC%9D%98-%EC%84%B8%EB%A1%9C-%EC%9D%B4%EB%AF%B8%EC%A7%80-%EC%95%8C%EC%BD%94%EC%98%AC-%EC%A4%91%EB%8F%85.jpg"
                alt="lager"
              />
            </button>
          </div>

          <!-- 에일 -->
          <div class="swiper-slide">
            <button class="slide-image" type="submit" name="ale" @click="pushRankCategory($event)">
              <img 
                src="https://en.pimg.jp/037/137/297/1/37137297.jpg" 
                alt="ale" 
              />
            </button>
          </div>

          <!-- 밀맥주 -->
          <div class="swiper-slide">
            <button class="slide-image" type="submit" name="wheat" @click="pushRankCategory($event)">
              <img 
                src="https://en.pimg.jp/037/137/297/1/37137297.jpg" 
                alt="wheat" 
              />
            </button>
          </div>

          <!-- 스타우트 -->
          <div class="swiper-slide">
            <button class="slide-image" type="submit" name="scout" @click="pushRankCategory($event)">
              <img 
                src="https://en.pimg.jp/037/137/297/1/37137297.jpg" 
                alt="scout" 
              />
            </button>
          </div>

          <!-- 라들러/RTD -->
          <div class="swiper-slide">
            <button class="slide-image" type="submit" name="rtd" @click="pushRankCategory($event)">
              <img 
                src="https://en.pimg.jp/037/137/297/1/37137297.jpg" 
                alt="rtd" 
              />
            </button>
          </div>

        </div>
        <div class="swiper-pagination"></div>
      </div>
    </div>
  </div>
</template>

<script>
// import RankingCategory from "./RankingCategoryPage.vue";

export default {
  name: "RankingMain", //컴포넌트 이름
  components: {
    // RankingCategory,
  },
  data() {
    //html과 자바스크립트 코드에서 사용할 데이터 변수 선언
    return {
      sampleData: "",
    };
  },
  setup() {}, //컴포지션 API
  created() {}, //컴포넌트가 생성되면 실행
  mounted() {
    new Swiper(".swiper-container", {
      slidesPerView: "auto",
      initialSlide: 2,
      speed: 1000,
      spaceBetween: 32,
      loop: true,
      centeredSlides: true,
      roundLengths: true,
      mousewheel: true,
      grabCursor: true,
      pagination: {
        el: ".swiper-pagination",
        clickable: true,
      },
    });
  }, //template에 정의된 html코드가 레너링된 후 실행
  unmounted() {}, //unmount가 완료된 후 실행
  methods: {
    pushRankCategory(event) {
      this.$router.push({
        name: "RankingCategory",
        params: { category: event.target.alt },
      });
    },  
  }, //컴포넌트 내에서 사용할 메소드 정의
};
</script>

<style lang="scss">
// https://dribbble.com/shots/6763080-Cruise-Tech-Motion-Study

$breakpoints: (
  "sm": 50px,
  "md": 108px,
  "lg": 1024px,
);

$theme-color: #939597;

#ranking-wrapper {
  background-color: white;
  height: 100%;
  width: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

// title
#ranking-title {
  // display: flex;
  // justify-content: center;
  margin: 10px;
}

// ==========================================
// SWIPER
// ==========================================

.swiper-container {
  //슬라이드 세로 길이
  height: 450px;
  //슬라이드 전체 가로 길이
  width: 1500px;
  padding-bottom: 85px;
  padding-top: 12px;
}

.swiper-wrapper {
  // enough width to have off screen slides partially visible
  width: 60%;
  will-change: transform;
}

.swiper-slide {
  width: 90%;
  background-color: white;
  overflow: hidden;

  &.swiper-slide-active,
  &.swiper-slide-duplicate-active {
    .slide-image {
      transform: scale3d(1, 1, 1);
    }
  }

  @media (min-width: map-get($breakpoints, "sm")) {
    width: 100%;

    &.swiper-slide-next,
    &.swiper-slide-prev,
    &.swiper-slide-duplicate-next,
    &.swiper-slide-duplicate-prev {
      .slide-image {
        transform: scale3d(1, 1, 1);
      }
    }
  }

  @media (min-width: map-get($breakpoints, "md")) {
    width: 33.333333%;

    &.swiper-slide-next,
    &.swiper-slide-prev,
    &.swiper-slide-duplicate-next,
    &.swiper-slide-duplicate-prev {
      .slide-image {
        transform: scale3d(1, 1, 1);
      }
    }
  }
}

.swiper-pagination {
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 85px;

  // chained selector hack to handle very specific overrides
  &#{&} {
    bottom: 0;
  }
}

.swiper-pagination-bullet {
  background: $theme-color;
  width: 22px;
  height: 4px;
  border-radius: 0;
  transition: opacity 1s ease;

  &#{&}#{&} {
    margin: 0;
  }

  @media (min-width: map-get($breakpoints, "md")) {
    width: 40px;
  }
}

// ==========================================
// SLIDES
// ==========================================

.slide-image {
  height: 100%;
  width: 100%;
  padding: 0;
  background-repeat: no-repeat;
  background-size: cover;
  background-position: center;
  transform: scale3d(1.3, 1.3, 1); // 3d to hardware accelerate
  backface-visibility: hidden;
  will-change: transform;
  transition: transform 1400ms ease;

  button {
    padding: 0;
  }
  img {
    object-fit: contain;
  }
}

.slide-content {
  padding: 0 2.2rem;
  display: flex;
  flex-direction: column;
  height: 100%;

  h4 {
    font-size: 25px;
    font-weight: 400;
    margin: 0 0 1rem;
    padding-top: 2.8rem;
    flex-grow: 0;
  }

  p {
    display: flex;
    line-height: 1.8;
    margin-top: 0;
    font-size: 14px;
    flex-grow: 1;
  }

  footer {
    display: flex;
    justify-content: space-between;
    width: 100%;
    padding-bottom: 2.8rem;
    font-size: 14px;
    color: #c2c0e0;
  }

  a {
    color: $theme-color;
    font-size: 12px;
    font-weight: 700;
    text-decoration: none;
    border-bottom: 3px solid currentColor;
    padding-bottom: 3px;
  }
  video{
    display: none;
    }
}
</style>
