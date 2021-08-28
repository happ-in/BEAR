# BEAR



<div align="center">
  <img src="https://user-images.githubusercontent.com/36289638/131223545-01ec302b-e49c-4e1e-a4b2-2489aa3df935.png" />
  <h2> Zootopia 🦝🦊🐰🦁  </h2>
    <a href="https://github.com/happ-in/BEAR/graphs/contributors">
      <img src="https://contrib.rocks/image?repo=happ-in/BEAR" />
    </a>
</div>



||[박상준](https://github.com/june11215)|[박민광](https://github.com/minkpang)|[박혜빈](https://github.com/happ-in)|[전예지](https://github.com/yeahaluu)|
|-|:-:|:-:|:-:|:-:|
|**역할**|전체 팀장|FE 팀장|BE 팀장|디자인팀장|
|**사진**|<img src="https://user-images.githubusercontent.com/36289638/131222987-85622468-2594-445b-8ef9-616b24f38f07.png" width="220" height="300" />|<img src="https://user-images.githubusercontent.com/36289638/131222927-d5bb537c-2666-42c6-bd64-ba579f568adc.png"  width="220" height="300"  />|<img src="https://user-images.githubusercontent.com/36289638/131223029-1fafd140-9fc8-46c8-9692-5fe19235ee7d.png"  width="220" height="300" />|<img src="https://user-images.githubusercontent.com/36289638/131222893-370290e9-8530-4538-b6d2-a7e158fde8a9.png" width="220" height="300" />|
|**제작**|카카오 API연동 <br/> (로그인, 공유) <br/>|AR 오픈소스 렛시 <br/> (타겟 인식, 3D 렌더링)|DB 설계 <br/> BE <br/> FE  <br/> AWS BE 배포|Jira <br/> FE <br/> AWS FE 배포|



<br/>



## ✍🏻기획배경

코로나19 상황에서 혼술족, 혼맥족이 증가하였다. 이에 따라 맥주 시장도 증가하며 다양한 맥주가 나왔다. 편의점에서 4캔 만원 행사를 할 때, 좋아하는 맥주와 함께 새로운 맥주를 사곤 하는데 단순히 디자인이 예뻐 샀다가 낭패를 본 경험이 있다. 이러한 실패를 없애고 싶어서 BEAR를 기획하게 되었다.

카메라로 맥주를 비추면 맥주에 대한 정보(도수, 국가, 맥주명 등)이 나오고 사용자들의 리뷰가 해시태그로 화면에 나오도록 했다. 이 때, 오픈소스 [렛시](https://www.letsee.io/ko/)를 사용하여 브라우저에서 AR을 사용했다. 사용자는 다른 사용자를 팔로잉/팔로우하여 서로 쓴 리뷰를 볼 수 있다. 또한, 내가 작성한 리뷰(맥주 이미지, 해시태그)를 카카오톡 공유로 타인에게 보낼 수 있도록 하였다.



<br/>



## 🙏🏻 기대효과

1.  맥주 선택에 있어 실패 확률 감소
2.  AR 기능을 이용한 책, 향수 등 다양한 매체로의 확장



<br/>


## 🛠 Architecture & 기술스택/배포

- ⭐Certbot을 이용하여 HTTPS 배포⭐
- ⭐AR의 경우 오픈소스인 렛시를 사용⭐

  


![image](https://user-images.githubusercontent.com/36289638/130325226-37864867-01cd-43e8-8708-9a10c76f258e.png)



<br/>



## 🕋 DB ERD

![image](https://user-images.githubusercontent.com/36289638/130327184-011fe1f4-42a0-432b-a0d2-edb31b94e9b7.png)



<br/>



## 📚 자료

#### [📄 Documents](https://drive.google.com/drive/folders/1nWqjPvvZnD7TtoOIX39ah03JNh4sA0HP)

#### [🍻 와이어프레임](https://www.figma.com/file/MAbZRQljnkd26LKbzxEy5k/BEAR)

#### [📺 UCC](https://youtu.be/k9ZZYctwgz0)  

#### [🎬 시연영상](https://www.youtube.com/watch?v=mQJGjZQTsCY&t=19s)

