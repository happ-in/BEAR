export default {
  name: "", //컴포넌트 이름
  components: {},
  data() {
    //html과 자바스크립트 코드에서 사용할 데이터 변수 선언
    return {
      sampleData: "hidden",
      beerData: {
        beerName: "수집중",
        hashTags: []
      },
      brName: "no",
      country: "",
      star: "",
      beerAvg: "",
    };
  },
  setup() {}, //컴포지션 API
  created() {
    letsee.ready(() => {
      letsee.start();
      // letsee
      //   .addTarget(
      //     //곰표
      //     "https://developer.letsee.io/api-tm/target-manager/target-uid/6114a3733f9ee405ea644b27"
      //   )
      //   .then((entity) => {
      //     let div = this.$refs.con;
      //     div.style.width = 360 + "px";
      //     div.style.height = 640 + "px";
      //     const xrElement = letsee.createXRElement(div);
      //     letsee.bindXRElement(xrElement, entity);
      //   });
      // letsee
      //   .addTarget(
      //     //피츠
      //     "https://developer.letsee.io/api-tm/target-manager/target-uid/6114a36d2f7b8005cc146efc"
      //   )
      //   .then((entity) => {
      //     let div = this.$refs.con;
      //     div.style.width = 360 + "px";
      //     div.style.height = 640 + "px";
      //     const xrElement = letsee.createXRElement(div);
      //     letsee.bindXRElement(xrElement, entity);
      //   });
      // letsee //파울라너 둔켈
      //   .addTarget("https://developer.letsee.io/api-tm/target-manager/target-uid/6114a13656197305fc5c1322")
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
      // letsee //하이트
      //   .addTarget("https://developer.letsee.io/api-tm/target-manager/target-uid/61148b092f7b8005cc146efa")
      //   .then((entity) => {
      //     let div = this.$refs.con;
      //     div.style.width = 360 + "px";
      //     div.style.height = 640 + "px";
      //     const xrElement = letsee.createXRElement(div);
      //     letsee.bindXRElement(xrElement, entity);
      //   });
      letsee //제주위트에일
      .addTarget(
        "https://developer.letsee.io/api-tm/target-manager/target-uid/611d225e2f7b8005cc146f00"
      )
      .then((entity) => {
        let div = this.$refs.con;
        div.style.width = 360 + "px";
        div.style.height = 640 + "px";
        const xrElement = letsee.createXRElement(div);
        letsee.bindXRElement(xrElement, entity);
      });
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
      // letsee //카스 라이트
      // .addTarget(
      //   "https://developer.letsee.io/api-tm/target-manager/target-uid/6114896df8e80a05ba9010d8"
      // )
      // .then((entity) => {
      //   let div = this.$refs.con;
      //   div.style.width = 360 + "px";
      //   div.style.height = 640 + "px";
      //   const xrElement = letsee.createXRElement(div);
      //   letsee.bindXRElement(xrElement, entity);
      // });
      letsee //카스 후레시
        .addTarget("https://developer.letsee.io/api-tm/target-manager/target-uid/611489683f9ee405ea644b23")
        .then((entity) => {
          let div = this.$refs.con;
          div.style.width = 360 + "px";
          div.style.height = 640 + "px";
          const xrElement = letsee.createXRElement(div);
          letsee.bindXRElement(xrElement, entity);
        });
      // letsee //칼스버그
      //   .addTarget("https://developer.letsee.io/api-tm/target-manager/target-uid/611489632f7b8005cc146ef9")
      //   .then((entity) => {
      //     let div = this.$refs.con;
      //     div.style.width = 360 + "px";
      //     div.style.height = 640 + "px";
      //     const xrElement = letsee.createXRElement(div);
      //     letsee.bindXRElement(xrElement, entity);
      //   });
      // letsee //버드와이저
      //   .addTarget("https://developer.letsee.io/api-tm/target-manager/target-uid/6114895e3f9ee405ea644b22")
      //   .then((entity) => {
      //     let div = this.$refs.con;
      //     div.style.width = 360 + "px";
      //     div.style.height = 640 + "px";
      //     const xrElement = letsee.createXRElement(div);
      //     letsee.bindXRElement(xrElement, entity);
      //   });
      // letsee //블루문
      // .addTarget(
      //   "https://developer.letsee.io/api-tm/target-manager/target-uid/6114895956197305fc5c1321"
      // )
      // .then((entity) => {
      //   let div = this.$refs.con;
      //   div.style.width = 360 + "px";
      //   div.style.height = 640 + "px";
      //   const xrElement = letsee.createXRElement(div);
      //   letsee.bindXRElement(xrElement, entity);
      // });
      // letsee //구스 아일랜드
      // .addTarget(
      //   "https://developer.letsee.io/api-tm/target-manager/target-uid/6114894ff8e80a05ba9010d7"
      // )
      // .then((entity) => {
      //   let div = this.$refs.con;
      //   div.style.width = 360 + "px";
      //   div.style.height = 640 + "px";
      //   const xrElement = letsee.createXRElement(div);
      //   letsee.bindXRElement(xrElement, entity);
      // });
      // letsee //에델바이스
      // .addTarget(
      //   "https://developer.letsee.io/api-tm/target-manager/target-uid/61148935f8e80a05ba9010d6"
      // )
      // .then((entity) => {
      //   let div = this.$refs.con;
      //   div.style.width = 360 + "px";
      //   div.style.height = 640 + "px";
      //   const xrElement = letsee.createXRElement(div);
      //   letsee.bindXRElement(xrElement, entity);
      // });
      // letsee //데스페라도스
      //   .addTarget("https://developer.letsee.io/api-tm/target-manager/target-uid/6114892ff8e80a05ba9010d5")
      //   .then((entity) => {
      //     let div = this.$refs.con;
      //     div.style.width = 360 + "px";
      //     div.style.height = 640 + "px";
      //     const xrElement = letsee.createXRElement(div);
      //     letsee.bindXRElement(xrElement, entity);
      //   });
      // letsee //빅웨이브
      //   .addTarget("https://developer.letsee.io/api-tm/target-manager/target-uid/61148929f8e80a05ba9010d4")
      //   .then((entity) => {
      //     let div = this.$refs.con;
      //     div.style.width = 360 + "px";
      //     div.style.height = 640 + "px";
      //     const xrElement = letsee.createXRElement(div);
      //     letsee.bindXRElement(xrElement, entity);
      //   });
      // letsee //호가든 로제
      //   .addTarget("https://developer.letsee.io/api-tm/target-manager/target-uid/6114891a3f9ee405ea644b21")
      //   .then((entity) => {
      //     let div = this.$refs.con;
      //     div.style.width = 360 + "px";
      //     div.style.height = 640 + "px";
      //     const xrElement = letsee.createXRElement(div);
      //     letsee.bindXRElement(xrElement, entity);
      //   });
      letsee //하이네켄
        .addTarget("https://developer.letsee.io/api-tm/target-manager/target-uid/6114890f56197305fc5c1320")
        .then((entity) => {
          let div = this.$refs.con;
          div.style.width = 360 + "px";
          div.style.height = 640 + "px";
          const xrElement = letsee.createXRElement(div);
          letsee.bindXRElement(xrElement, entity);
        });
      // letsee //한맥
      //   .addTarget("https://developer.letsee.io/api-tm/target-manager/target-uid/6114890a3f9ee405ea644b20")
      //   .then((entity) => {
      //     let div = this.$refs.con;
      //     div.style.width = 360 + "px";
      //     div.style.height = 640 + "px";
      //     const xrElement = letsee.createXRElement(div);
      //     letsee.bindXRElement(xrElement, entity);
      //   });
      letsee //기네스
        .addTarget("https://developer.letsee.io/api-tm/target-manager/target-uid/611489013f9ee405ea644b1f")
        .then((entity) => {
          let div = this.$refs.con;
          div.style.width = 360 + "px";
          div.style.height = 640 + "px";
          const xrElement = letsee.createXRElement(div);
          letsee.bindXRElement(xrElement, entity);
        });
      letsee //블랑
        .addTarget("https://developer.letsee.io/api-tm/target-manager/target-uid/611488f72f7b8005cc146ef8")
        .then((entity) => {
          let div = this.$refs.con;
          div.style.width = 360 + "px";
          div.style.height = 640 + "px";
          const xrElement = letsee.createXRElement(div);
          letsee.bindXRElement(xrElement, entity);
        });
      // letsee //파울라너 뮌헨라거
      // .addTarget(
      //   "https://developer.letsee.io/api-tm/target-manager/target-uid/611488f13f9ee405ea644b1e"
      // )
      // .then((entity) => {
      //   let div = this.$refs.con;
      //   div.style.width = 360 + "px";
      //   div.style.height = 640 + "px";
      //   const xrElement = letsee.createXRElement(div);
      //   letsee.bindXRElement(xrElement, entity);
      // });
      // letsee //밀러
      // .addTarget(
      //   "https://developer.letsee.io/api-tm/target-manager/target-uid/611488e63f9ee405ea644b1d"
      // )
      // .then((entity) => {
      //   let div = this.$refs.con;
      //   div.style.width = 360 + "px";
      //   div.style.height = 640 + "px";
      //   const xrElement = letsee.createXRElement(div);
      //   letsee.bindXRElement(xrElement, entity);
      // });
      // letsee //필스너 우르켈
      // .addTarget(
      //   "https://developer.letsee.io/api-tm/target-manager/target-uid/611488e03f9ee405ea644b1c"
      // )
      // .then((entity) => {
      //   let div = this.$refs.con;
      //   div.style.width = 360 + "px";
      //   div.style.height = 640 + "px";
      //   const xrElement = letsee.createXRElement(div);
      //   letsee.bindXRElement(xrElement, entity);
      // });
      // letsee // 서머스비
      //   .addTarget("https://developer.letsee.io/api-tm/target-manager/target-uid/611488d72f7b8005cc146ef6")
      //   .then((entity) => {
      //     let div = this.$refs.con;
      //     div.style.width = 360 + "px";
      //     div.style.height = 640 + "px";
      //     const xrElement = letsee.createXRElement(div);
      //     letsee.bindXRElement(xrElement, entity);
      //   });
      // letsee // 산미구엘
      // .addTarget(
      //   "https://developer.letsee.io/api-tm/target-manager/target-uid/611488d12f7b8005cc146ef5"
      // )
      // .then((entity) => {
      //   let div = this.$refs.con;
      //   div.style.width = 360 + "px";
      //   div.style.height = 640 + "px";
      //   const xrElement = letsee.createXRElement(div);
      //   letsee.bindXRElement(xrElement, entity);
      // });
      // letsee //코젤
      //   .addTarget("https://developer.letsee.io/api-tm/target-manager/target-uid/611488cb3f9ee405ea644b1b")
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
      letsee //클라우드 생 드라프트
        .addTarget("https://developer.letsee.io/api-tm/target-manager/target-uid/611d1bb73f9ee405ea644b2d")
        .then((entity) => {
          let div = this.$refs.con;
          div.style.width = 360 + "px";
          div.style.height = 640 + "px";
          const xrElement = letsee.createXRElement(div);
          letsee.bindXRElement(xrElement, entity);
        });
      // letsee //타이거
      // .addTarget(
      //   "https://developer.letsee.io/api-tm/target-manager/target-uid/611488ac2f7b8005cc146ef3"
      // )
      // .then((entity) => {
      //   let div = this.$refs.con;
      //   div.style.width = 360 + "px";
      //   div.style.height = 640 + "px";
      //   const xrElement = letsee.createXRElement(div);
      //   letsee.bindXRElement(xrElement, entity);
      // });
      letsee //테라
        .addTarget("https://developer.letsee.io/api-tm/target-manager/target-uid/611488a63f9ee405ea644b19")
        .then((entity) => {
          let div = this.$refs.con;
          div.style.width = 360 + "px";
          div.style.height = 640 + "px";
          const xrElement = letsee.createXRElement(div);
          letsee.bindXRElement(xrElement, entity);
        });
      letsee //스텔라
        .addTarget("https://developer.letsee.io/api-tm/target-manager/target-uid/611d1bc056197305fc5c1323")
        .then((entity) => {
          let div = this.$refs.con;
          div.style.width = 360 + "px";
          div.style.height = 640 + "px";
          const xrElement = letsee.createXRElement(div);
          letsee.bindXRElement(xrElement, entity);
        });
      letsee //칭따오
        .addTarget("https://developer.letsee.io/api-tm/target-manager/target-uid/611dc75a3f9ee405ea644b2e")
        .then((entity) => {
          let div = this.$refs.con;
          div.style.width = 360 + "px";
          div.style.height = 640 + "px";
          const xrElement = letsee.createXRElement(div);
          letsee.bindXRElement(xrElement, entity);
        });
      letsee //호가든
        .addTarget("https://developer.letsee.io/api-tm/target-manager/target-uid/611480742f7b8005cc146ef2")
        .then((entity) => {
          let div = this.$refs.con;
          div.style.width = 360 + "px";
          div.style.height = 640 + "px";
          const xrElement = letsee.createXRElement(div);
          letsee.bindXRElement(xrElement, entity);
        });
      this.$refs.btn1.style.visibility = "hidden";
      this.$refs.btn2.style.visibility = "hidden";
      this.$refs.btn3.style.visibility = "hidden";
      this.$refs.btn4.style.visibility = "hidden";
      setTimeout(() => {
        this.$refs.loading.style.visibility = "hidden";
        this.$refs.load.style.visibility = "hidden";
        this.$refs.btn1.style.visibility = "visible";
        this.$refs.btn2.style.visibility = "visible";     
      }, 3000);
      letsee.onTrackStart((e) => {
        this.$refs.btn3.style.visibility = "visible";
        this.$refs.btn4.style.visibility = "visible";
        this.$refs.guide.style.visibility = "hidden";
        this.$refs.guide.style["z-index"] = 0;
        this.getBeerData(e.trace.entity.substr(81, 4));
        setTimeout(() => {
          this.$refs.title.innerHTML = " " + this.beerData.beerName + "";
          this.$refs.rate.innerHTML = " " + (this.beerData.beerAvg).toFixed(1) + "";
          this.$refs.proof.innerHTML = " " + this.beerData.alcoholProof + "%";
          this.$refs.category.innerHTML = " " + this.beerData.beerCategory + "";
          this.$refs.country.innerHTML = " " + this.beerData.country.countryName + "";
          // this.country = "i5a403.p.ssafy.io" + require("../assets/flags/" + this.beerData.country.countryName + ".png");
          // this.star = require("../assets/stars/" + Math.floor(this.beerData.beerAvg) + ".png");
          
          if (Math.floor(this.beerData.beerAvg) == 5) { this.$refs.star.innerHTML = "★★★★★"; }
          else if (Math.floor(this.beerData.beerAvg) == 4) { this.$refs.star.innerHTML = "★★★★☆"; }
          else if (Math.floor(this.beerData.beerAvg) == 3) { this.$refs.star.innerHTML = "★★★☆☆"; }
          else if (Math.floor(this.beerData.beerAvg) == 2) { this.$refs.star.innerHTML = "★★☆☆☆"; }
          else if (Math.floor(this.beerData.beerAvg) == 1) { this.$refs.star.innerHTML = "★☆☆☆☆"; }
          else{this.$refs.star.innerHTML = "☆☆☆☆☆"; }
          
          if (this.beerData.hashTags.length == 0) {this.$refs.hash1.innerHTML = " ";}
          else{this.$refs.hash1.innerHTML = " #" + this.beerData.hashTags[0].hashTagName + "";}    
          if (this.beerData.hashTags.length == 1) { this.$refs.hash2.innerHTML = " "; }
          else{this.$refs.hash2.innerHTML = " #" + this.beerData.hashTags[1].hashTagName + "";}
          if (this.beerData.hashTags.length == 2) { this.$refs.hash3.innerHTML = " "; }
          else{this.$refs.hash3.innerHTML = " #" + this.beerData.hashTags[2].hashTagName + "";}
          // this.$refs.hash4.innerHTML = " #" + this.beerData.hashTags[3].hashTagName + "";
          if (this.beerData.hashTags.length == 3) {this.$refs.hash4.innerHTML = " ";}
          else{this.$refs.hash4.innerHTML = " #" + this.beerData.hashTags[3].hashTagName + "";}
        }, 300);
      });
      letsee.onTrackEnd((e) => {
        this.$refs.guide.style.visibility = "visible";
        this.$refs.btn3.style.visibility = "hidden";
        this.$refs.btn4.style.visibility = "hidden";
        this.$refs.guide.style["z-index"] = 500;

      });
      this.$refs.guide.style.visibility = "visible";
      this.$refs.guide.style["z-index"] = 500;
    });
    letsee.init();
  }, //컴포넌트가 생성되면 실행
  mounted() {}, //template에 정의된 html코드가 레너링된 후 실행
  unmounted() {}, //unmount가 완료된 후 실행
  methods: {
    recommendFood() {
      window.open("detail/" + this.beerData.beerId + "");
    },
    goProfile() {
      window.open("myprofile");
    },
    goSearch() {
      window.open("search");
    },
    goReview() {
      window.open("review/write?beerId=" + this.beerData.beerId);
    },
    async getBeerData(id) {
      this.beerData = await this.$api("beer/ar?searchId=" + id, "get"); //test API
    },
  }, //컴포넌트 내에서 사용할 메소드 정의
};
