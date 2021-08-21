<template>
  <div id="ranking-wrapper">
    <div><h1 class="header">랭킹</h1></div>

    <div class="swiper-container">
      <div class="swiper-wrapper">

        <div class="swiper-slide">
          <button class="slide-image" type="submit" name="stout" @click="pushRankCategory($event)">
            <img 
              src="../assets/rankingMain/stout.png" alt="stout" />
          </button>
        </div>
        <div class="swiper-slide">
          <button class="slide-image" type="submit" name="rtd" @click="pushRankCategory($event)">
            <img src="../assets/rankingMain/rtd.png" alt="rtd"/>
          </button>
        </div>
        <div class="swiper-slide">
          <button class="slide-image" type="submit" name="all" @click="pushRankCategory($event)">
            <img src="../assets/rankingMain/all.png"
              alt="all"
            />
          </button>
        </div>
        <div class="swiper-slide">
          <button class="slide-image" type="submit" name="lager" @click="pushRankCategory($event)">
            <img src="../assets/rankingMain/lager.png" alt="lager"/>
          </button>
        </div>
        <div class="swiper-slide">
          <button class="slide-image" type="submit" name="ale" @click="pushRankCategory($event)">
            <img src="../assets/rankingMain/ale.png" alt="ale" />
          </button>
        </div>
        <div class="swiper-slide">
          <button class="slide-image" type="submit" name="wheat" @click="pushRankCategory($event)">
            <img 
              src="../assets/rankingMain/wheat.png"
              alt="wheat" 
            />
          </button>
        </div>
      </div>

      <div class="swiper-pagination"></div>

    </div>
  </div>
</template>

<script>
export default {
  name: "RankingMain",
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
  },
  methods: {
    pushRankCategory(event) {
      this.$router.push({
        name: "RankingCategory",
        params: { category: event.target.alt },
      });
    },  
  },
};
</script>

<style lang="scss">
$theme-color: #939597;

#ranking-wrapper {
  background-color: white;
  height: 100%;
  width: 100%;
  display: flex;
  flex-direction: column;
}
#ranking-title {
  margin: 10px;
}
// swiper
.swiper-container {
  height: 600px;
  width: 420px;
  margin-top: 1%;
  padding-top: 12px;
}
.swiper-wrapper {
  width: 60%;
  height:70%;
  
  will-change: transform;
}
.swiper-slide {
  width: 100%;
  height: 720px;
    &.swiper-slide-next,
    &.swiper-slide-prev,
    &.swiper-slide-duplicate-next,
    &.swiper-slide-duplicate-prev {
      .slide-image {
        transform: scale3d(1, 1, 1);
      }
    }
}
.swiper-pagination {
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 40px;

  &#{&} {
    bottom: 0;
  }
}
.swiper-pagination-bullet {
  background: $theme-color;
  width: 50px;
  height: 4px;
  border-radius: 0;
  transition: opacity 1s ease;

  &#{&}#{&} {
    margin: 0;
  }
}
// slider
.slide-image {
  height: 50vh;
  width: 30vh;
  padding: 0;
  border: 0;
  background-repeat: no-repeat;
  background-size: cover;
  background-position: center;
  transform: scale3d(1.3, 1.3, 1);
  backface-visibility: hidden;
  will-change: transform;
  transition: transform 1400ms ease;

  img {
    width:100%;
    height:100%;
    object-fit: cover;
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
