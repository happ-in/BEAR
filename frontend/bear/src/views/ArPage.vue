<template>
<img id="loading" ref="loading" src="../assets/landing/5.png"/>
<img id="load" ref="load" src="../assets/landing/load.gif">
<!-- 화면가이드  -->
  <div id="guide" ref="guide"> 
    <div id="guide_inner_1">  
      <svg
        id="guide_img"
        xmlns="http://www.w3.org/2000/svg"
        width="336"
        height="170"
        viewBox="0 0 336 170"
      >
      <defs></defs>
      <g id="img_area" transform="translate(-20 -176)">
        <path
                id="topleft"
                d="M-415 32V0h32v4h-28v28z"
                class="cls-1"
                transform="translate(435 176)"
              />
              <path
                id="bottomright"
                d="M-415 32V0h32v4h-28v28z"
                class="cls-1"
                transform="rotate(180 -29.5 323)"
              />
              <path
                id="topright"
                d="M-415 32V0h32v4h-28v28z"
                class="cls-1"
                transform="rotate(90 -117.5 473.5)"
              />
              <path
                id="bottomleft"
                d="M-415 32V0h32v4h-28v28z"
                class="cls-1"
                transform="rotate(-90 125.5 105.5)"
              />
            </g>
          </svg>
        </div>
        <div id="guide_inner_2">
          <p id="guide_msg">
            로고를 프레임에<br/>
            맞춰주세요.
          </p>
        </div>
  </div>
  <!-- 검색버튼 -->
  <div id="btn_nav1" ref="btn1">
    <svg
      id="guide_img"
      xmlns="http://www.w3.org/2000/svg"
      width="300"
      height="200"
      viewBox="0 -20 300 200"
      fill="white"
    >
      <path
        @click="goSearch"
        d="M31.008 27.231l-7.58-6.447c-0.784-0.705-1.622-1.029-2.299-0.998 1.789-2.096 2.87-4.815 2.87-7.787 0-6.627-5.373-12-12-12s-12 5.373-12 12 5.373 12 12 12c2.972 0 5.691-1.081 7.787-2.87-0.031 0.677 0.293 1.515 0.998 2.299l6.447 7.58c1.104 1.226 2.907 1.33 4.007 0.23s0.997-2.903-0.23-4.007zM12 20c-4.418 0-8-3.582-8-8s3.582-8 8-8 8 3.582 8 8-3.582 8-8 8z"
      ></path>
      </svg>
  </div>
  <!-- 프로필버튼 -->
  <div id="btn_nav2" ref="btn2">
    <svg
      id="guide_img"
      xmlns="http://www.w3.org/2000/svg"
      width="300"
      height="200"
      viewBox="-200 -20 300 200"
      fill="white"
    >
      <path
        @click="goProfile"
        d="M18 22.082v-1.649c2.203-1.241 4-4.337 4-7.432 0-4.971 0-9-6-9s-6 4.029-6 9c0 3.096 1.797 6.191 4 7.432v1.649c-6.784 0.555-12 3.888-12 7.918h28c0-4.030-5.216-7.364-12-7.918z"
      ></path>
    </svg>
  </div>
  <!-- 안주추천 버튼 -->
  <div>
  <div id="btn_div" ref="btn3">
      <svg 
          class="btn_more"
          id="btn_more"
          xmlns="http://www.w3.org/2000/svg"
          width="110"
          height="62"
          viewBox="-55 0 110 62"
      >
      <defs>
        <filter
          id="xdxotu3hsa2"
          width="110"
          height="62"
          x="0"
          y="0"
          filterUnits="userSpaceOnUse"
        >
          <feOffset dx="3" dy="3" />
          <feGaussianBlur result="blur" stdDeviation="3" />
          <feFlood flood-opacity=".302" />
          <feComposite in2="blur" operator="in" />
          <feComposite in="SourceGraphic" />
        </filter>
        <filter
          id="w2ozhmi69b2"
          width="92"
          height="30"
          x="21.5"
          y="13.5"
          filterUnits="userSpaceOnUse"
        >
          <feOffset />
          <feGaussianBlur result="blur-2" stdDeviation="1.5" />
          <feFlood flood-opacity=".161" />
          <feComposite in2="blur-2" operator="in" />
          <feComposite in="SourceGraphic" />
        </filter>
      </defs>
      <g>
        <g
          filter="url(#xdxotu3hsa)"
          transform="translate(-82 -122) translate(82 122)"
        >
          <path fill="#F5DF4D" d="M0 0H140V44H0z" transform="translate(6 6)" />
        </g>
        <g
          @click="recommendFood"
          filter="url(#w2ozhmi69b)"
          transform="translate(-82 -122) translate(82 122)"
        >
          <text
            fill="#fff"
            font-family="AppleSDGothicNeo-ExtraBold, Apple SD Gothic Neo"
            font-size="18px"
            font-weight="800"
            transform="translate(26 34)"
            style="
              text-shadow: -1px 0 #939597, 0 1px #939597, 1px 0 #939597,
                0 -1px #939597;
              text-align: right;
            "
          >
            <tspan x="0" y="0">안주추천</tspan>
          </text>
          </g>
        </g>
      </svg>
    </div>
    <!-- 리뷰남기기 버튼 -->
    <div id="btn_div1" ref="btn4">
      <svg 
          class="btn_more"
          id="btn_more"
          xmlns="http://www.w3.org/2000/svg"
          width="110"
          height="62"
          viewBox="70 0 110 62"
      >
      <defs>
        <filter
          id="xdxotu3hsa"
          width="110"
          height="62"
          x="0"
          y="0"
          filterUnits="userSpaceOnUse"
        >
          <feOffset dx="3" dy="3" />
          <feGaussianBlur result="blur" stdDeviation="3" />
          <feFlood flood-opacity=".302" />
          <feComposite in2="blur" operator="in" />
          <feComposite in="SourceGraphic" />
        </filter>
        <filter
          id="w2ozhmi69b"
          width="92"
          height="30"
          x="21.5"
          y="13.5"
          filterUnits="userSpaceOnUse"
        >
          <feOffset />
          <feGaussianBlur result="blur-2" stdDeviation="1.5" />
          <feFlood flood-opacity=".161" />
          <feComposite in2="blur-2" operator="in" />
          <feComposite in="SourceGraphic" />
        </filter>
      </defs>
      <g>
        <g
          filter="url(#xdxotu3hsa)"
          transform="translate(-82 -122) translate(82 122)"
        >
          <path fill="#F5DF4D" d="M0 0H140V44H0z" transform="translate(6 6)" />
        </g>
        <g
          @click="goReview"
          filter="url(#w2ozhmi69b)"
          transform="translate(-82 -122) translate(82 122)"
        >
          <text
            fill="#fff"
            font-family="AppleSDGothicNeo-ExtraBold, Apple SD Gothic Neo"
            font-size="18px"
            font-weight="800"
            transform="translate(26 34)"
            style="
              text-shadow: -1px 0 #939597, 0 1px #939597, 1px 0 #939597,
                0 -1px #939597;
              text-align: right;
            "
          >
            <tspan x="0" y="0">리뷰쓰기</tspan>
          </text>
          </g>
        </g>
      </svg>
    </div>
    </div>
    <div id="container" ref="con">
  <p id="beer_hash_one" ref="hash1"></p>
  <p id="beer_hash_two" ref="hash2"></p>
  <p id="beer_hash_three" ref="hash3"></p>
  <p id="beer_hash_four" ref="hash4"></p>
  <p id="beer_title" @click="goReview" ref="title"></p>
  <p id="beer_star" ref="rate"></p>
  <p id="alcohol" ref="proof"></p>
  <p id="category" ref="category"></p>
  <p id="country" ref="country"></p>
  <p ref="flag"></p>
  <p id="star" ref="star"></p>

  
</div>
</template>
<script>
  import Ar from '../utils/ar_load';
  export default Ar;  
</script>
<style>

#guide_msg {
  width: 220px;
  height: 55px;
  text-shadow: 0 0 3px #000000;
  font-family: "Noto Sans KR", sans-serif;
  font-size: 18px;
  font-weight: bold;
  font-stretch: normal;
  font-style: normal;
  line-height: 1.56;
  letter-spacing: normal;
  text-align: center;
  color: #ffffff;
}

#guide {
  position: absolute;
  width: 100%;
  height: 100%;
  transform: translate(-50%, -50%);
  top: 50%;
  left: 50%;
  visibility: hidden;
  background-image: uri("./img_area.png");
}

#loading {
  position: absolute;
  width: 360px;
  height: 640px;
  transform: translate(-50%, -50%);
  top: 50%;
  left: 50%;
  visibility: visible;
  z-index: 600;
  background-image: uri("../assets/landing/1.png");
}

#load {
  position: absolute;
  width: 40px;
  height: 40px;
  transform: translate(-50%, -50%);
  top: 65%;
  left: 50%;
  visibility: visible;
  z-index: 600;
  background-image: uri("../assets/landing/load.png");
}

#guide_inner_1 {
  position: absolute;
  transform: translate(-50%, -50%);
  top: 50%;
  left: 50%;
  height: 470px;
  box-shadow: 0 0 0 100vmax rgba(139, 138, 144, 0.7);
}

#guide_inner_2 {
  position: absolute;
  transform: translate(-50%, -50%);
  top: 50%;
  left: 50%;
}
#star {
  position: absolute;
  width: 200px;
  height: 43px;
  left: 80px;
  top: 15%;
  font-size: 50px;
  text-align: center;
  color: #ffce31;

  text-shadow: 3px 3px 3px rgb(0, 0, 0);
}
#btn_div {
  width: 60%;
  height: 40px;
  margin-bottom: 50px;
  position: absolute;
  transform: translate(-50%, -50%);
  top: 85%;
  left: 20%;
  bottom: 0;
  display: flex;
  align-content: center;
  justify-content: center;
  z-index: 600;
  visibility: visible;
  border-radius: 50px;
}

#btn_div1 {
  width: 60%;
  height: 40px;
  margin-bottom: 50px;
  position: absolute;
  transform: translate(-50%, -50%);
  top: 85%;
  left: 80%;
  bottom: 0;
  display: flex;
  align-content: center;
  justify-content: center;
  z-index: 600;
  visibility: visible;
  border-radius: 50px;
}

#btn_nav1 {
  width: 100%;
  height: 640px;
  margin-top: 50px;
  position: absolute;
  transform: translate(-50%, -50%);
  top: 36%;
  left: 50%;
  bottom: 0;
  display: flex;
  align-content: center;
  justify-content: center;
  z-index: 600;
  visibility: visible;
  border-radius: 50px;
}

#btn_nav2 {
  width: 100%;
  height: 640px;
  margin-top: 50px;
  position: absolute;
  transform: translate(-50%, -50%);
  top: 36%;
  left: 70%;
  bottom: 0;
  display: flex;
  align-content: center;
  justify-content: center;
  z-index: 600;
  visibility: visible;
  border-radius: 50px;
}

.btn_more {
  width: 420px;
  height: 60px;
  object-fit: contain;
}

/* #flag{
  position: absolute;
  width: 30px;
  height: 30px;
  left: 271px;
  top: 71px;
} */

#country {
  position: absolute;
  width: 30px;
  height: 30px;
  background-color: #f5df4d;
  border-radius: 50%;
  left: 275px;
  text-align: center;
  top: 52px;
  text-shadow: 3px 3px 3px rgb(0, 0, 0);
  box-shadow: 3px 3px 3px rgb(0, 0, 0);
  /* margin: 0 auto; */

  font-family: Noto Sans;
  font-style: normal;
  font-weight: bold;
  font-size: 8px;
  line-height: 25px;

  color: #ffffff;
}


#alcohol {
  position: absolute;
  width: 30px;
  height: 30px;
  background-color: #f5df4d;
  border-radius: 50%;
  left: 240px;
  text-align: center;
  top: 45px;
  text-shadow: 3px 3px 3px rgb(0, 0, 0);
  box-shadow: 3px 3px 3px rgb(0, 0, 0);
  /* margin: 0 auto; */

  font-family: Noto Sans;
  font-style: normal;
  font-weight: bold;
  font-size: 15px;
  line-height: 25px;

  color: #ffffff;
}

#category {
  position: absolute;
  width: 30px;
  height: 30px;
  background-color: #f5df4d;
  border-radius: 50%;
  left: 205px;
  text-align: center;
  top: 45px;
  text-shadow: 3px 3px 3px rgb(0, 0, 0);
  box-shadow: 3px 3px 3px rgb(0, 0, 0);
  /* margin: 0 auto; */

  font-family: Noto Sans;
  font-style: normal;
  font-weight: bold;
  font-size: 15px;
  line-height: 25px;

  color: #ffffff;
}

#beer_hash_one {
  position: absolute;
  width: 254px;
  height: 72px;
  left: -4.28px;
  top: 278.02px;

  font-family: Noto Sans;
  font-style: normal;
  font-weight: bold;
  font-size: 60px;
  line-height: 68px;
  text-shadow: 3px 3px 3px rgb(0, 0, 0);

  color: #ffffff;

  opacity: 0.98;
  transform: rotate(4deg);
}
#beer_hash_two {
  position: absolute;
  width: 195px;
  height: 48px;
  left: 25.43px;
  top: 386.3px;
  text-shadow: 3px 3px 3px rgb(0, 0, 0);

  font-family: Noto Sans;
  font-style: normal;
  font-weight: bold;
  font-size: 34px;
  line-height: 33px;

  color: #ffffff;
  transform: rotate(1deg);
}
#beer_hash_three {
  position: absolute;
  width: 200px;
  height: 33px;
  left: 209.46px;
  top: calc(50% - 33px / 2 + 146.67px);

  font-family: Noto Sans;
  font-style: normal;
  font-weight: bold;
  font-size: 46px;
  line-height: 35px;
  text-shadow: 3px 3px 3px rgb(0, 0, 0);

  color: rgba(255, 255, 255, 0.71);
  transform: rotate(-2deg);
}
#beer_hash_four {
  position: absolute;
  width: 200px;
  height: 39px;
  left: 219px;
  top: 277.7px;

  font-family: Noto Sans;
  font-style: normal;
  font-weight: bold;
  font-size: 44px;
  line-height: 33px;

  color: #ffffff;
  text-shadow: 3px 3px 3px rgb(0, 0, 0);

  opacity: 0.8;
  transform: rotate(-4deg);
}
#beer_title {
  position: absolute;
  width: 360px;
  height: 32px;
  /* left: 20%; */
  text-align: center;
  top: 55px;
  text-shadow: 3px 3px 3px rgb(0, 0, 0);
  /* margin: 0 auto; */

  font-family: Noto Sans;
  font-style: normal;
  font-weight: bold;
  font-size: 40px;
  line-height: 41px;

  color: #ffffff;
}
#beer_star {
  position: absolute;
  width: 76px;
  height: 50px;
  left: 169px;
  top: 156px;

  font-family: Noto Sans;
  font-style: normal;
  font-weight: bold;
  font-size: 48px;
  line-height: 65px;
  text-shadow: 3px 3px 3px rgb(0, 0, 0);

  color: #ffce31;
}
</style>
