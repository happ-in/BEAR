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
  <div id="btn_nav1" ref="btn1" @click="goSearch">
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
  <div id="btn_div" ref="btn3">
      <svg 
          class="btn_more"
          id="btn_more"
          xmlns="http://www.w3.org/2000/svg"
          width="110"
          height="62"
          viewBox="0 0 110 62"
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
    <div id="container" ref="con">
  <p id="beer_hash_one" ref="hash1"></p>
  <p id="beer_hash_two" ref="hash2"></p>
  <p id="beer_hash_three" ref="hash3"></p>
  <p id="beer_hash_four" ref="hash4"></p>
  <p id="beer_title" @click="goReview" ref="title"></p>
  <p id="beer_star" ref="rate"></p>
  <p ref="country"></p>
  <p ref="flag"></p>
  <p ref="star"></p>
  <p>{{this.brName}}</p>
</div>
</template>
<script>

  export default {
        name: '', //컴포넌트 이름
        components: {},
        data() { //html과 자바스크립트 코드에서 사용할 데이터 변수 선언
            return {
                sampleData: 'hidden',
                beerData: {"beerName":'수집중'},
                brName: 'no',
                country: '',
                star:''

            };
        },
        setup() {}, //컴포지션 API
        created() {
          letsee.ready(() => {
            letsee.start();
            letsee
              .addTarget(//곰표
                "https://developer.letsee.io/api-tm/target-manager/target-uid/6114a3733f9ee405ea644b27"
              )
              .then((entity) => {
                let div = this.$refs.con;
                div.style.width = 360 + "px";
                div.style.height = 640 + "px";
                const xrElement = letsee.createXRElement(div);
                letsee.bindXRElement(xrElement, entity);
              });

            // letsee
            //   .addTarget(//피츠
            //     "https://developer.letsee.io/api-tm/target-manager/target-uid/6114a36d2f7b8005cc146efc"
            //   )
            //   .then((entity) => {
            //     let div = this.$refs.con;
            //     div.style.width = 360 + "px";
            //     div.style.height = 640 + "px";
            //     const xrElement = letsee.createXRElement(div);
            //     letsee.bindXRElement(xrElement, entity);
            //   });
            //   letsee //파울라너 둔켈
            //   .addTarget(
            //     "https://developer.letsee.io/api-tm/target-manager/target-uid/6114a13656197305fc5c1322"
            //   )
            //   .then((entity) => {
            //     let div = this.$refs.con;
            //     div.style.width = 360 + "px";
            //     div.style.height = 640 + "px";
            //     const xrElement = letsee.createXRElement(div);
            //     letsee.bindXRElement(xrElement, entity);
            //   });
            //   letsee //예거라들러자몽
            //   .addTarget(
            //     "https://developer.letsee.io/api-tm/target-manager/target-uid/61148b9e2f7b8005cc146efb"
            //   )
            //   .then((entity) => {
            //     let div = this.$refs.con;
            //     div.style.width = 360 + "px";
            //     div.style.height = 640 + "px";
            //     const xrElement = letsee.createXRElement(div);
            //     letsee.bindXRElement(xrElement, entity);
            //   });
            //   letsee //예거라들러레몬
            //   .addTarget(
            //     "https://developer.letsee.io/api-tm/target-manager/target-uid/61148b643f9ee405ea644b26"
            //   )
            //   .then((entity) => {
            //     let div = this.$refs.con;
            //     div.style.width = 360 + "px";
            //     div.style.height = 640 + "px";
            //     const xrElement = letsee.createXRElement(div);
            //     letsee.bindXRElement(xrElement, entity);
            //   });
            //   letsee //카프리
            //   .addTarget(
            //     "https://developer.letsee.io/api-tm/target-manager/target-uid/61148b2c3f9ee405ea644b25"
            //   )
            //   .then((entity) => {
            //     let div = this.$refs.con;
            //     div.style.width = 360 + "px";
            //     div.style.height = 640 + "px";
            //     const xrElement = letsee.createXRElement(div);
            //     letsee.bindXRElement(xrElement, entity);
            //   });
            //   letsee //하이트
            //   .addTarget(
            //     "https://developer.letsee.io/api-tm/target-manager/target-uid/61148b092f7b8005cc146efa"
            //   )
            //   .then((entity) => {
            //     let div = this.$refs.con;
            //     div.style.width = 360 + "px";
            //     div.style.height = 640 + "px";
            //     const xrElement = letsee.createXRElement(div);
            //     letsee.bindXRElement(xrElement, entity);
            //   });
            //   letsee //제주위트에일
            //   .addTarget(
            //     "https://developer.letsee.io/api-tm/target-manager/target-uid/61148adb3f9ee405ea644b24"
            //   )
            //   .then((entity) => {
            //     let div = this.$refs.con;
            //     div.style.width = 360 + "px";
            //     div.style.height = 640 + "px";
            //     const xrElement = letsee.createXRElement(div);
            //     letsee.bindXRElement(xrElement, entity);
            //   });
            //   letsee //아사히
            //   .addTarget(
            //     "https://developer.letsee.io/api-tm/target-manager/target-uid/6114897bf8e80a05ba9010d9"
            //   )
            //   .then((entity) => {
            //     let div = this.$refs.con;
            //     div.style.width = 360 + "px";
            //     div.style.height = 640 + "px";
            //     const xrElement = letsee.createXRElement(div);
            //     letsee.bindXRElement(xrElement, entity);
            //   });
            //   letsee //카스 라이트
            //   .addTarget(
            //     "https://developer.letsee.io/api-tm/target-manager/target-uid/6114896df8e80a05ba9010d8"
            //   )
            //   .then((entity) => {
            //     let div = this.$refs.con;
            //     div.style.width = 360 + "px";
            //     div.style.height = 640 + "px";
            //     const xrElement = letsee.createXRElement(div);
            //     letsee.bindXRElement(xrElement, entity);
            //   });
            //   letsee //카스 후레시
            //   .addTarget(
            //     "https://developer.letsee.io/api-tm/target-manager/target-uid/611489683f9ee405ea644b23"
            //   )
            //   .then((entity) => {
            //     let div = this.$refs.con;
            //     div.style.width = 360 + "px";
            //     div.style.height = 640 + "px";
            //     const xrElement = letsee.createXRElement(div);
            //     letsee.bindXRElement(xrElement, entity);
            //   });
            //   letsee //칼스버그
            //   .addTarget(
            //     "https://developer.letsee.io/api-tm/target-manager/target-uid/611489632f7b8005cc146ef9"
            //   )
            //   .then((entity) => {
            //     let div = this.$refs.con;
            //     div.style.width = 360 + "px";
            //     div.style.height = 640 + "px";
            //     const xrElement = letsee.createXRElement(div);
            //     letsee.bindXRElement(xrElement, entity);
            //   });
            //   letsee //버드와이저
            //   .addTarget(
            //     "https://developer.letsee.io/api-tm/target-manager/target-uid/6114895e3f9ee405ea644b22"
            //   )
            //   .then((entity) => {
            //     let div = this.$refs.con;
            //     div.style.width = 360 + "px";
            //     div.style.height = 640 + "px";
            //     const xrElement = letsee.createXRElement(div);
            //     letsee.bindXRElement(xrElement, entity);
            //   });
            //   letsee //블루문
            //   .addTarget(
            //     "https://developer.letsee.io/api-tm/target-manager/target-uid/6114895956197305fc5c1321"
            //   )
            //   .then((entity) => {
            //     let div = this.$refs.con;
            //     div.style.width = 360 + "px";
            //     div.style.height = 640 + "px";
            //     const xrElement = letsee.createXRElement(div);
            //     letsee.bindXRElement(xrElement, entity);
            //   });
            //   letsee //구스 아일랜드
            //   .addTarget(
            //     "https://developer.letsee.io/api-tm/target-manager/target-uid/6114894ff8e80a05ba9010d7"
            //   )
            //   .then((entity) => {
            //     let div = this.$refs.con;
            //     div.style.width = 360 + "px";
            //     div.style.height = 640 + "px";
            //     const xrElement = letsee.createXRElement(div);
            //     letsee.bindXRElement(xrElement, entity);
            //   });
            //   letsee //에델바이스 
            //   .addTarget(
            //     "https://developer.letsee.io/api-tm/target-manager/target-uid/61148935f8e80a05ba9010d6"
            //   )
            //   .then((entity) => {
            //     let div = this.$refs.con;
            //     div.style.width = 360 + "px";
            //     div.style.height = 640 + "px";
            //     const xrElement = letsee.createXRElement(div);
            //     letsee.bindXRElement(xrElement, entity);
            //   });
            //   letsee //데스페라도스
            //   .addTarget(
            //     "https://developer.letsee.io/api-tm/target-manager/target-uid/6114892ff8e80a05ba9010d5"
            //   )
            //   .then((entity) => {
            //     let div = this.$refs.con;
            //     div.style.width = 360 + "px";
            //     div.style.height = 640 + "px";
            //     const xrElement = letsee.createXRElement(div);
            //     letsee.bindXRElement(xrElement, entity);
            //   });
            //   letsee //빅웨이브 
            //   .addTarget(
            //     "https://developer.letsee.io/api-tm/target-manager/target-uid/61148929f8e80a05ba9010d4"
            //   )
            //   .then((entity) => {
            //     let div = this.$refs.con;
            //     div.style.width = 360 + "px";
            //     div.style.height = 640 + "px";
            //     const xrElement = letsee.createXRElement(div);
            //     letsee.bindXRElement(xrElement, entity);
            //   });
            //   letsee //호가든 로제
            //   .addTarget(
            //     "https://developer.letsee.io/api-tm/target-manager/target-uid/6114891a3f9ee405ea644b21"
            //   )
            //   .then((entity) => {
            //     let div = this.$refs.con;
            //     div.style.width = 360 + "px";
            //     div.style.height = 640 + "px";
            //     const xrElement = letsee.createXRElement(div);
            //     letsee.bindXRElement(xrElement, entity);
            //   });
            //   letsee //하이네켄
            //   .addTarget(
            //     "https://developer.letsee.io/api-tm/target-manager/target-uid/6114890f56197305fc5c1320"
            //   )
            //   .then((entity) => {
            //     let div = this.$refs.con;
            //     div.style.width = 360 + "px";
            //     div.style.height = 640 + "px";
            //     const xrElement = letsee.createXRElement(div);
            //     letsee.bindXRElement(xrElement, entity);
            //   });
            //   letsee //한맥
            //   .addTarget(
            //     "https://developer.letsee.io/api-tm/target-manager/target-uid/6114890a3f9ee405ea644b20"
            //   )
            //   .then((entity) => {
            //     let div = this.$refs.con;
            //     div.style.width = 360 + "px";
            //     div.style.height = 640 + "px";
            //     const xrElement = letsee.createXRElement(div);
            //     letsee.bindXRElement(xrElement, entity);
            //   });
            //   letsee //기네스
            //   .addTarget(
            //     "https://developer.letsee.io/api-tm/target-manager/target-uid/611489013f9ee405ea644b1f"
            //   )
            //   .then((entity) => {
            //     let div = this.$refs.con;
            //     div.style.width = 360 + "px";
            //     div.style.height = 640 + "px";
            //     const xrElement = letsee.createXRElement(div);
            //     letsee.bindXRElement(xrElement, entity);
            //   });
            //   letsee //블랑
            //   .addTarget(
            //     "https://developer.letsee.io/api-tm/target-manager/target-uid/611488f72f7b8005cc146ef8"
            //   )
            //   .then((entity) => {
            //     let div = this.$refs.con;
            //     div.style.width = 360 + "px";
            //     div.style.height = 640 + "px";
            //     const xrElement = letsee.createXRElement(div);
            //     letsee.bindXRElement(xrElement, entity);
            //   });
            //   letsee //파울라너 뮌헨라거
            //   .addTarget(
            //     "https://developer.letsee.io/api-tm/target-manager/target-uid/611488f13f9ee405ea644b1e"
            //   )
            //   .then((entity) => {
            //     let div = this.$refs.con;
            //     div.style.width = 360 + "px";
            //     div.style.height = 640 + "px";
            //     const xrElement = letsee.createXRElement(div);
            //     letsee.bindXRElement(xrElement, entity);
            //   });
            //   letsee //밀러 
            //   .addTarget(
            //     "https://developer.letsee.io/api-tm/target-manager/target-uid/611488e63f9ee405ea644b1d"
            //   )
            //   .then((entity) => {
            //     let div = this.$refs.con;
            //     div.style.width = 360 + "px";
            //     div.style.height = 640 + "px";
            //     const xrElement = letsee.createXRElement(div);
            //     letsee.bindXRElement(xrElement, entity);
            //   });
            //   letsee //필스너 우르켈
            //   .addTarget(
            //     "https://developer.letsee.io/api-tm/target-manager/target-uid/611488e03f9ee405ea644b1c"
            //   )
            //   .then((entity) => {
            //     let div = this.$refs.con;
            //     div.style.width = 360 + "px";
            //     div.style.height = 640 + "px";
            //     const xrElement = letsee.createXRElement(div);
            //     letsee.bindXRElement(xrElement, entity);
            //   });
            //   letsee // 서머스비
            //   .addTarget(
            //     "https://developer.letsee.io/api-tm/target-manager/target-uid/611488d72f7b8005cc146ef6"
            //   )
            //   .then((entity) => {
            //     let div = this.$refs.con;
            //     div.style.width = 360 + "px";
            //     div.style.height = 640 + "px";
            //     const xrElement = letsee.createXRElement(div);
            //     letsee.bindXRElement(xrElement, entity);
            //   });
            //   letsee // 산미구엘
            //   .addTarget(
            //     "https://developer.letsee.io/api-tm/target-manager/target-uid/611488d12f7b8005cc146ef5"
            //   )
            //   .then((entity) => {
            //     let div = this.$refs.con;
            //     div.style.width = 360 + "px";
            //     div.style.height = 640 + "px";
            //     const xrElement = letsee.createXRElement(div);
            //     letsee.bindXRElement(xrElement, entity);
            //   });
            //   letsee //코젤 
            //   .addTarget(
            //     "https://developer.letsee.io/api-tm/target-manager/target-uid/611488cb3f9ee405ea644b1b"
            //   )
            //   .then((entity) => {
            //     let div = this.$refs.con;
            //     div.style.width = 360 + "px";
            //     div.style.height = 640 + "px";
            //     const xrElement = letsee.createXRElement(div);
            //     letsee.bindXRElement(xrElement, entity);
            //   });
            //   letsee //타이거라들러 자몽
            //   .addTarget(
            //     "https://developer.letsee.io/api-tm/target-manager/target-uid/611488c53f9ee405ea644b1a"
            //   )
            //   .then((entity) => {
            //     let div = this.$refs.con;
            //     div.style.width = 360 + "px";
            //     div.style.height = 640 + "px";
            //     const xrElement = letsee.createXRElement(div);
            //     letsee.bindXRElement(xrElement, entity);
            //   });
            //   letsee //타이거라들러 레몬
            //   .addTarget(
            //     "https://developer.letsee.io/api-tm/target-manager/target-uid/611488bf2f7b8005cc146ef4"
            //   )
            //   .then((entity) => {
            //     let div = this.$refs.con;
            //     div.style.width = 360 + "px";
            //     div.style.height = 640 + "px";
            //     const xrElement = letsee.createXRElement(div);
            //     letsee.bindXRElement(xrElement, entity);
            //   });
            //   letsee //클라우드 생 드라프트
            //   .addTarget(
            //     "https://developer.letsee.io/api-tm/target-manager/target-uid/611488b256197305fc5c131f"
            //   )
            //   .then((entity) => {
            //     let div = this.$refs.con;
            //     div.style.width = 360 + "px";
            //     div.style.height = 640 + "px";
            //     const xrElement = letsee.createXRElement(div);
            //     letsee.bindXRElement(xrElement, entity);
            //   });
            //   letsee //타이거
            //   .addTarget(
            //     "https://developer.letsee.io/api-tm/target-manager/target-uid/611488ac2f7b8005cc146ef3"
            //   )
            //   .then((entity) => {
            //     let div = this.$refs.con;
            //     div.style.width = 360 + "px";
            //     div.style.height = 640 + "px";
            //     const xrElement = letsee.createXRElement(div);
            //     letsee.bindXRElement(xrElement, entity);
            //   });
            //   letsee //테라
            //   .addTarget(
            //     "https://developer.letsee.io/api-tm/target-manager/target-uid/611488a63f9ee405ea644b19"
            //   )
            //   .then((entity) => {
            //     let div = this.$refs.con;
            //     div.style.width = 360 + "px";
            //     div.style.height = 640 + "px";
            //     const xrElement = letsee.createXRElement(div);
            //     letsee.bindXRElement(xrElement, entity);
            //   });
              letsee //스텔라 
              .addTarget(
                "https://developer.letsee.io/api-tm/target-manager/target-uid/611488a056197305fc5c131e"
              )
              .then((entity) => {
                let div = this.$refs.con;
                div.style.width = 360 + "px";
                div.style.height = 640 + "px";
                const xrElement = letsee.createXRElement(div);
                letsee.bindXRElement(xrElement, entity);
              });
              letsee //칭따오 
              .addTarget(
                "https://developer.letsee.io/api-tm/target-manager/target-uid/6114807ef8e80a05ba9010d3"
              )
              .then((entity) => {
                let div = this.$refs.con;
                div.style.width = 360 + "px";
                div.style.height = 640 + "px";
                const xrElement = letsee.createXRElement(div);
                letsee.bindXRElement(xrElement, entity);
              });
              letsee //호가든
              .addTarget(
                "https://developer.letsee.io/api-tm/target-manager/target-uid/611480742f7b8005cc146ef2"
              )
              .then((entity) => {
                let div = this.$refs.con;
                div.style.width = 360 + "px";
                div.style.height = 640 + "px";
                const xrElement = letsee.createXRElement(div);
                letsee.bindXRElement(xrElement, entity);
              });

            // document.getElementById("btn_more").addEventListener("click", () => {
            //   location.href = "https://www.naver.com/";
            // });
            this.$refs.btn1.style.visibility = "hidden";
            this.$refs.btn2.style.visibility = "hidden";
            this.$refs.btn3.style.visibility = "hidden";
            setTimeout(() => {
              this.$refs.loading.style.visibility = "hidden";
              this.$refs.load.style.visibility = "hidden";
              this.$refs.btn1.style.visibility = "visible";
              this.$refs.btn2.style.visibility = "visible";
              this.$refs.btn3.style.visibility = "visible";
            }, 5000)
            letsee.onTrackStart((e) => {
              this.$refs.guide.style.visibility = "hidden";
              this.$refs.guide.style["z-index"] = 0;
              this.getBeerData((e.trace.entity.substr(81,4)));
              console.log(e)
              this.$refs.title.innerHTML = " "+this.beerData.beerName+"";
              this.$refs.rate.innerHTML = " "+this.beerData.beerAvg+"";
              this.country = require('../assets/flags/'+this.beerData.country.countryName+'.png')
              this.star = require('../assets/stars/'+Math.floor(this.beerData.beerAvg)+'.png')
              this.$refs.country.innerHTML = " "+this.beerData.country.countryName+"";
              this.$refs.flag.innerHTML= "<img id=flag src="+this.country +"/>";
              this.$refs.star.innerHTML= "<img id=star src="+this.star +"/>";
              this.$refs.hash1.innerHTML = " "+this.beerData.hashTags[0].hashTagName+"";
              this.$refs.hash2.innerHTML = " "+this.beerData.hashTags[1].hashTagName+"";
              this.$refs.hash3.innerHTML = " "+this.beerData.hashTags[2].hashTagName+"";
              this.$refs.hash4.innerHTML = " "+this.beerData.hashTags[3].hashTagName+"";
              
            });
            letsee.onTrackEnd((e) => {
              this.$refs.guide.style.visibility = "visible";
              this.$refs.guide.style["z-index"] = 500;
              console.log(e.trace.entity.substr(81,4))
              console.log(this.sampleData);
              this.getBeerData((e.trace.entity.substr(81,4)));
            });
            
            this.$refs.guide.style.visibility = "visible";
            this.$refs.guide.style["z-index"] = 500;
            //this.$refs.btn_div.style.visibility = "visible";
            });
          letsee.init();
          }, //컴포넌트가 생성되면 실행
        mounted() {
        }, //template에 정의된 html코드가 레너링된 후 실행
        unmounted() {}, //unmount가 완료된 후 실행
        methods: {recommendFood(){
            // this.$router.push('/');
            window.open('https://i5a403.p.ssafy.io/beer/detail?beerId='+this.beerData.beerId+'');
          },goProfile(){
            this.$router.push('/profile');
            window.open('https://i5a403.p.ssafy.io/beer/profile');
          },goSearch(){
            window.open('https://i5a403.p.ssafy.io/beer/search');
          },goReview(){
            window.open('https://i5a403.p.ssafy.io/beer/search');
          },
          async getBeerData(id) {
            this.beerData = await this.$api("https://i5a403.p.ssafy.io/beer/ar?searchId="+id,"get"); //test API
            console.log(this.beerData);
          }
    } //컴포넌트 내에서 사용할 메소드 정의
    }
  
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
  top: 117px;
}
#btn_div {
  width: 100%;
  height: 40px;
  margin-bottom: 50px;
  position: absolute;
  transform: translate(-50%, -50%);
  top: 85%;
  left: 50%;
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
  top: 43%;
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
  top: 43%;
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
  width: 200px;
  height: 60px;
  object-fit: contain;
}

#flag{
  position: absolute;
  width: 30px;
  height: 30px;
  left: 271px;
  top: 61px;
}
#beer_hash_one {
  position: absolute;
  width: 174px;
  height: 72px;
  left: -4.28px;
  top: 278.02px;

  font-family: Noto Sans;
  font-style: normal;
  font-weight: bold;
  font-size: 50px;
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
  font-size: 24px;
  line-height: 33px;

  color: #ffffff;
  transform: rotate(1deg);
}
#beer_hash_three {
  position: absolute;
  width: 124px;
  height: 33px;
  left: 209.46px;
  top: calc(50% - 33px / 2 + 146.67px);

  font-family: Noto Sans;
  font-style: normal;
  font-weight: bold;
  font-size: 26px;
  line-height: 35px;
  text-shadow: 3px 3px 3px rgb(0, 0, 0);

  color: rgba(255, 255, 255, 0.71);
  transform: rotate(-2deg);
}
#beer_hash_four {
  position: absolute;
  width: 139px;
  height: 39px;
  left: 219px;
  top: 277.7px;

  font-family: Noto Sans;
  font-style: normal;
  font-weight: bold;
  font-size: 24px;
  line-height: 33px;

  color: #ffffff;
  text-shadow: 3px 3px 3px rgb(0, 0, 0);

  opacity: 0.8;
  transform: rotate(-4deg);
}
#beer_title {
  position: absolute;
  width: 300px;
  height: 32px;
  left: 58px;
  top: 55px;
  text-shadow: 3px 3px 3px rgb(0, 0, 0);
  /* margin: 0 auto; */

  font-family: Noto Sans;
  font-style: normal;
  font-weight: bold;
  font-size: 30px;
  line-height: 41px;

  color: #ffffff;
}
#beer_star {
  position: absolute;
  width: 76px;
  height: 50px;
  left: 159px;
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
