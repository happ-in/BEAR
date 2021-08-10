<template>
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
  <div id="btn_nav">
    <svg
        id="guide_img"
        xmlns="http://www.w3.org/2000/svg"
        width="300"
        height="200"
        viewBox="0 -20 300 200"
        fill="white"
      >
      <path @click="goSearch"
        d="M31.008 27.231l-7.58-6.447c-0.784-0.705-1.622-1.029-2.299-0.998 1.789-2.096 2.87-4.815 2.87-7.787 0-6.627-5.373-12-12-12s-12 5.373-12 12 5.373 12 12 12c2.972 0 5.691-1.081 7.787-2.87-0.031 0.677 0.293 1.515 0.998 2.299l6.447 7.58c1.104 1.226 2.907 1.33 4.007 0.23s0.997-2.903-0.23-4.007zM12 20c-4.418 0-8-3.582-8-8s3.582-8 8-8 8 3.582 8 8-3.582 8-8 8z"
      ></path>
    </svg>
  </div>
  <!-- 프로필버튼 -->
  <div id="btn_nav">
    <svg
        id="guide_img"
        xmlns="http://www.w3.org/2000/svg"
        width="300"
        height="200"
        viewBox="-270 -20 300 200"
        fill="white"
      >
      <path @click="goProfile"
          d="M18 22.082v-1.649c2.203-1.241 4-4.337 4-7.432 0-4.971 0-9-6-9s-6 4.029-6 9c0 3.096 1.797 6.191 4 7.432v1.649c-6.784 0.555-12 3.888-12 7.918h28c0-4.030-5.216-7.364-12-7.918z"
      ></path>
      </svg>
    </div>
  <!-- 안주추천 버튼 -->
  <div id="btn_div">
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
          <path
            fill="#F5DF4D"
            d="M0 0H140V44H0z"
            transform="translate(6 6)"
          />
        </g>
        <g @click="recommendFood" 
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
              text-align: right;"
              >
          <tspan x="0" y="0">안주추천</tspan>
          </text>
          </g>
        </g>
      </svg>
    </div>
    <div id="container" ref="con">
  <h1>Hello, world!{{this.sampleData}}{{this.beerData}}</h1>
  <p id="beer_hash_one">#커피향</p>
  <p id="beer_hash_two">#수제흑맥주</p>
  <p id="beer_hash_three">#쌉쌀한맛</p>
  <p id="beer_hash_four">#흑맥주입문</p>
  <p id="beer_title">{{this.beerData.beerName}}</p>
  <p id="beer_star">4.2</p>
  <p ref="test"></p>
</div>
</template>
<script>
  export default {
        name: '', //컴포넌트 이름
        components: {},
        data() { //html과 자바스크립트 코드에서 사용할 데이터 변수 선언
            return {
                sampleData: 'hidden',
                beerData: [],
                brName: 'no',
            };
        },
        setup() {}, //컴포지션 API
        created() {
          letsee.ready(() => {
            letsee.start();
            letsee
              .addTarget(
                // "https://developer.letsee.io/api-tm/target-manager/target-uid/61123eff130fc5b620875e3b"
                "https://developer.letsee.io/api-tm/target-manager/target-uid/6100c1be332d3ccecddc2804"
              )
              .then((entity) => {
                //this.getBeerData(1);
                let div = this.$refs.con;
                const xrElement = letsee.createXRElement(div);
                letsee.bindXRElement(xrElement, entity);
              });

            letsee
              .addTarget(
                "https://developer.letsee.io/api-tm/target-manager/target-uid/60f7cf8a398942b60ead2d39"
              )
              .then((entity) => {
                //this.getBeerData(2);
                let div = this.$refs.con;
                const xrElement = letsee.createXRElement(div);
                letsee.bindXRElement(xrElement, entity);
              });
              letsee //칭따오
              .addTarget(
                "https://developer.letsee.io/api-tm/target-manager/target-uid/610c9268130fc5b620875e38"
              )
              .then((entity) => {
                //const { width, height } = entity.physicalSize;
                const div = document.createElement("div");
                div.style.width = 360 + "px";
                div.style.height = 640 + "px";
                //this.getBeerData(13);
                div.innerHTML = `
                          <p id="beer_hash_one">#양꼬치</p>
                          <p id="beer_hash_two">#무난무난</p>
                          <p id="beer_hash_three">#깔끔한맛</p>
                          <p id="beer_hash_four">#중국음식이랑</p>
                          <p id="beer_title">칭따오</p>
                          <p id="beer_star">3.8</p>
                          `;

                const xrElement = letsee.createXRElement(div);
                letsee.bindXRElement(xrElement, entity);
              });

            document.getElementById("btn_more").addEventListener("click", () => {
              location.href = "https://www.naver.com/";
            });
            letsee.onTrackStart((e) => {
              this.$refs.guide.style.visibility = "hidden";
              this.$refs.guide.style["z-index"] = 0;
              this.sampleData = e;//.trace.entity;
              this.brName = this.beerData.beerName;
              this.getBeerData((e.trace.entity.substr(84,1)));
              this.$refs.test.innerHTML = " "+this.beerData.title+"";
              
            });
            letsee.onTrackEnd((e) => {
              this.$refs.guide.style.visibility = "visible";
              this.$refs.guide.style["z-index"] = 500;
              console.log('TrackEnd');
              console.log(e.trace.entity.substr(60,25));
              console.log(e.trace.entity.substr(84,1))

              console.log(this.sampleData);
              this.brName = this.beerData.beerName;
              this.getBeerData(1);
              axios.get('https://i5a403.p.ssafy.io?beerId=7')
                .then(response => {
                  console.log(response);
                })
              console.log(this.brName);
              console.log(this.beerData);
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
        methods: {recommendFood: () => {
          window.open("https://www.naver.com/");
          },goProfile: () => {
          window.open("https://www.naver.com/");
          },goSearch: () => {
          window.open("https://www.naver.com/");
          },
          async getBeerData(id) {
            this.beerData = await this.$api("https://jsonplaceholder.typicode.com/todos/"+id,"get"); //test API
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

#btn_div {
  width: 100%;
  height: 40px;
  position: fixed;
  margin-bottom: 50px;
  bottom: 0;
  display: flex;
  align-content: center;
  justify-content: center;
  z-index: 600;
  visibility: visible;
  border-radius: 50px;
}

#btn_nav {
  width: 100%;
  height: 640px;
  position: fixed;
  margin-top: 50px;
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
  width: 182px;
  height: 32px;
  left: 118px;
  top: 55px;
  text-shadow: 3px 3px 3px rgb(0, 0, 0);

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