CREATE DATABASE `zootopia` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

CREATE TABLE `badge` (
  `badge_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `badge_explain` varchar(100) DEFAULT NULL,
  `badge_condition` varchar(100) DEFAULT NULL,
  `badge_image` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`badge_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `beer` (
  `beer_id` int(10) NOT NULL,
  `beer_name` varchar(50) DEFAULT NULL,
  `beer_category` varchar(20) DEFAULT NULL,
  `country_name` varchar(20) DEFAULT NULL,
  `alcohol_proof` double DEFAULT NULL,
  `beer_image` varchar(200) DEFAULT NULL,
  `search_id` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`beer_id`),
  UNIQUE KEY `beer_name_UNIQUE` (`beer_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `bookmark` (
  `user_id` bigint(20) NOT NULL,
  `beer_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`beer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `country` (
  `country_name` varchar(50) NOT NULL,
  `country_image` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`country_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `follow` (
  `user_id` bigint(20) NOT NULL,
  `follow_user_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`follow_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `hash_tag` (
  `hash_tag_id` int(11) NOT NULL AUTO_INCREMENT,
  `hash_tag_name` varchar(30) NOT NULL,
  PRIMARY KEY (`hash_tag_id`),
  UNIQUE KEY `hash_tag_name_UNIQUE` (`hash_tag_name`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `review` (
  `review_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `beer_id` int(11) DEFAULT NULL,
  `rating` double DEFAULT NULL,
  `start_date` timestamp NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`review_id`),
  UNIQUE KEY `unique_user_id_beer_id` (`user_id`,`beer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `review_hash_tag` (
  `review_id` int(11) NOT NULL,
  `hash_tag_id` int(11) NOT NULL,
  `beer_id` int(11) NOT NULL,
  PRIMARY KEY (`review_id`,`hash_tag_id`),
  CONSTRAINT `fk_review_hash_tag_review` FOREIGN KEY (`review_id`) REFERENCES `review` (`review_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `review_like` (
  `user_id` int(11) NOT NULL,
  `review_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`review_id`),
  KEY `fk_review_like_review_idx` (`review_id`),
  CONSTRAINT `fk_review_like_review` FOREIGN KEY (`review_id`) REFERENCES `review` (`review_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `snack_category` (
  `snack_category_name` varchar(20) NOT NULL,
  `beer_category` varchar(20) NOT NULL,
  PRIMARY KEY (`beer_category`,`snack_category_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `snack_detail` (
  `snack_category_name` varchar(20) NOT NULL,
  `snack_detail_name` varchar(50) NOT NULL,
  `snack_image` varchar(100) DEFAULT 'N',
  PRIMARY KEY (`snack_category_name`,`snack_detail_name`),
  UNIQUE KEY `snack_detail_name_UNIQUE` (`snack_detail_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL,
  `custom_id` varchar(20) DEFAULT NULL,
  `nickname` varchar(20) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `user_image` varchar(100) DEFAULT NULL,
  `share_count` int(11) DEFAULT 0,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `custom_id_UNIQUE` (`custom_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `user_badge` (
  `user_id` int(11) NOT NULL,
  `badge_id` int(11) DEFAULT NULL,
  `acquisition_date` timestamp NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into beer(beer_name, country_name, category,alcohol_proof) values("세븐로이 곰표 밀맥주","밀맥주","대한민국",4.5);
insert into beer(beer_name, country_name, category,alcohol_proof) values("구스 아일랜드 IPA","에일","미국",5.9);
insert into beer(beer_name, country_name, category,alcohol_proof) values("기네스 오리지널","스타우트","아일랜드",4.2);
insert into beer(beer_name, country_name, category,alcohol_proof) values("데스페라도스 오리지널","라거","네덜란드",5.9);
insert into beer(beer_name, country_name, category,alcohol_proof) values("밀러 제뉴인 드래프트","라거","미국",4.7);
insert into beer(beer_name, country_name, category,alcohol_proof) values("버드와이저","라거","미국",5);
insert into beer(beer_name, country_name, category,alcohol_proof) values("블루문","밀맥주","미국",5.4);
insert into beer(beer_name, country_name, category,alcohol_proof) values("산 미겔 페일 필젠","라거","필리핀",5);
insert into beer(beer_name, country_name, category,alcohol_proof) values("스텔라 아루투아","라거","벨기에",5);
insert into beer(beer_name, country_name, category,alcohol_proof) values("써머스비 사이다","라들러/RTD","덴마크",4.5);
insert into beer(beer_name, country_name, category,alcohol_proof) values("아사히 슈퍼드라이","라거","일본",5);
insert into beer(beer_name, country_name, category,alcohol_proof) values("에델바이스","밀맥주","오스트리아",5);
insert into beer(beer_name, country_name, category,alcohol_proof) values("예거 레몬 라들러","라들러/RTD","오스트리아",2.2);
insert into beer(beer_name, country_name, category,alcohol_proof) values("예거 복숭아 라들러","라들러/RTD","오스트리아",2.1);
insert into beer(beer_name, country_name, category,alcohol_proof) values("제주 위트 에일","에일","대한민국",5.3);
insert into beer(beer_name, country_name, category,alcohol_proof) values("칭따오","라거","중국",4.7);
insert into beer(beer_name, country_name, category,alcohol_proof) values("카스 라이트","라거","대한민국",4);
insert into beer(beer_name, country_name, category,alcohol_proof) values("카스 후레시","라거","대한민국",5);
insert into beer(beer_name, country_name, category,alcohol_proof) values("카프리","라거","대한민국",4.2);
insert into beer(beer_name, country_name, category,alcohol_proof) values("칼스버그 대니쉬 필스너","라거","덴마크",5);
insert into beer(beer_name, country_name, category,alcohol_proof) values("코나 빅 웨이브 골든에일","에일","미국",4.4);
insert into beer(beer_name, country_name, category,alcohol_proof) values("코젤 다크","스타우트","체코",4.6);
insert into beer(beer_name, country_name, category,alcohol_proof) values("크로넨버그 1664 블랑","밀맥주","프랑스",5);
insert into beer(beer_name, country_name, category,alcohol_proof) values("클라우드 생드리프트","라거","대한민국",5);
insert into beer(beer_name, country_name, category,alcohol_proof) values("타이거","라거","싱가포르",5);
insert into beer(beer_name, country_name, category,alcohol_proof) values("타이거 라들러 자몽","라들러/RTD","싱가포르",2);
insert into beer(beer_name, country_name, category,alcohol_proof) values("타이거 라들러 레몬","라들러/RTD","싱가포르",2);
insert into beer(beer_name, country_name, category,alcohol_proof) values("테라","라거","대한민국",4.6);
insert into beer(beer_name, country_name, category,alcohol_proof) values("파울라너 뮌헨 라거","라거","독일",4.9);
insert into beer(beer_name, country_name, category,alcohol_proof) values("파울라너 바이스비어 둔켈","스타우트","독일",5.3);
insert into beer(beer_name, country_name, category,alcohol_proof) values("피츠 수퍼클리어","라거","대한민국",4.5);
insert into beer(beer_name, country_name, category,alcohol_proof) values("필스너 우르켈","라거","체코",4.4);
insert into beer(beer_name, country_name, category,alcohol_proof) values("하이네켄 라거","라거","네덜란드",5);
insert into beer(beer_name, country_name, category,alcohol_proof) values("하이트 엑스트라 콜드","라거","대한민국",4.5);
insert into beer(beer_name, country_name, category,alcohol_proof) values("한맥","라거","대한민국",4.6);
insert into beer(beer_name, country_name, category,alcohol_proof) values("호가든","밀맥주","벨기에",4.9);
insert into beer(beer_name, country_name, category,alcohol_proof) values("호가든 로제","라들러/RTD","벨기에",3);

insert into snack_detail(snack_category_name, snack_detail_name) values ('짭잘한', '포카칩');
insert into snack_detail(snack_category_name, snack_detail_name) values ('짭잘한', '눈을 감자');
insert into snack_detail(snack_category_name, snack_detail_name) values ('짭잘한', '도도한 나쵸');
insert into snack_detail(snack_category_name, snack_detail_name) values ('짭잘한', '매운 새우깡');
insert into snack_detail(snack_category_name, snack_detail_name) values ('짭잘한', '오징어 숏다리');
insert into snack_detail(snack_category_name, snack_detail_name) values ('짭잘한', '스트링치즈');
insert into snack_detail(snack_category_name, snack_detail_name) values ('짭잘한', '오징어 땅콩');
insert into snack_detail(snack_category_name, snack_detail_name) values ('짭잘한', '오징어');
insert into snack_detail(snack_category_name, snack_detail_name) values ('짭잘한', '콘칩');
insert into snack_detail(snack_category_name, snack_detail_name) values ('짭잘한', '프레젤');
insert into snack_detail(snack_category_name, snack_detail_name) values ('짭잘한', '쥐포');
insert into snack_detail(snack_category_name, snack_detail_name) values ('짭잘한', '포스틱');
insert into snack_detail(snack_category_name, snack_detail_name) values ('고소한', '팝콘');
insert into snack_detail(snack_category_name, snack_detail_name) values ('고소한', '허니버터 아몬드');
insert into snack_detail(snack_category_name, snack_detail_name) values ('고소한', '견과류');
insert into snack_detail(snack_category_name, snack_detail_name) values ('고소한', '꼬북칩');
insert into snack_detail(snack_category_name, snack_detail_name) values ('고소한', '나쵸');
insert into snack_detail(snack_category_name, snack_detail_name) values ('고소한', '크래커');
insert into snack_detail(snack_category_name, snack_detail_name) values ('고소한', '육포');
insert into snack_detail(snack_category_name, snack_detail_name) values ('고소한', '땅콩');
insert into snack_detail(snack_category_name, snack_detail_name) values ('고소한', '참치크래커');
insert into snack_detail(snack_category_name, snack_detail_name) values ('고소한', '커피땅콩');
insert into snack_detail(snack_category_name, snack_detail_name) values ('고소한', '맥반석 오징어');
insert into snack_detail(snack_category_name, snack_detail_name) values ('기름진', '닭강정');
insert into snack_detail(snack_category_name, snack_detail_name) values ('기름진', '피자');
insert into snack_detail(snack_category_name, snack_detail_name) values ('기름진', '족발');
insert into snack_detail(snack_category_name, snack_detail_name) values ('기름진', '햄버거');
insert into snack_detail(snack_category_name, snack_detail_name) values ('기름진', '콘치즈 그라탕');
insert into snack_detail(snack_category_name, snack_detail_name) values ('자극적인', '떡볶이');
insert into snack_detail(snack_category_name, snack_detail_name) values ('자극적인', '치킨강정');
insert into snack_detail(snack_category_name, snack_detail_name) values ('자극적인', '얼큰한 오뎅');
insert into snack_detail(snack_category_name, snack_detail_name) values ('자극적인', '우동볶이');
insert into snack_detail(snack_category_name, snack_detail_name) values ('자극적인', '컵라면');
insert into snack_detail(snack_category_name, snack_detail_name) values ('자극적인', '닭발');
insert into snack_detail(snack_category_name, snack_detail_name) values ('자극적인', '닭꼬치');
insert into snack_detail(snack_category_name, snack_detail_name) values ('자극적인', '킬바사 소세지');
insert into snack_detail(snack_category_name, snack_detail_name) values ('자극적인', '안주야 매콤두루치기');
insert into snack_detail(snack_category_name, snack_detail_name) values ('자극적인', '오돌뼈');
insert into snack_detail(snack_category_name, snack_detail_name) values ('자극적인', '불막창');
insert into snack_detail(snack_category_name, snack_detail_name) values ('자극적인', '곱창볶음');
insert into snack_detail(snack_category_name, snack_detail_name) values ('자극적인', '볶음 순대');
insert into snack_detail(snack_category_name, snack_detail_name) values ('새콤한', '사과');
insert into snack_detail(snack_category_name, snack_detail_name) values ('새콤한', '파인애플');
insert into snack_detail(snack_category_name, snack_detail_name) values ('새콤한', '황도/백도');
insert into snack_detail(snack_category_name, snack_detail_name) values ('새콤한', '후르츠 칵테일');
insert into snack_detail(snack_category_name, snack_detail_name) values ('새콤한', '비빔면');
insert into snack_detail(snack_category_name, snack_detail_name) values ('새콤한', '쫄면');
insert into snack_detail(snack_category_name, snack_detail_name) values ('새콤한', '케이준 치킨 샐러드');
insert into snack_detail(snack_category_name, snack_detail_name) values ('새콤한', '과일믹스');
insert into snack_detail(snack_category_name, snack_detail_name) values ('달달한', '홈런볼');
insert into snack_detail(snack_category_name, snack_detail_name) values ('달달한', '하리보젤리');
insert into snack_detail(snack_category_name, snack_detail_name) values ('달달한', '허니버터칩');
insert into snack_detail(snack_category_name, snack_detail_name) values ('달달한', '꼬북칩 초코');
insert into snack_detail(snack_category_name, snack_detail_name) values ('달달한', '바나나킥');
insert into snack_detail(snack_category_name, snack_detail_name) values ('달달한', '초콜렛');
insert into snack_detail(snack_category_name, snack_detail_name) values ('달달한', '콘초');
insert into snack_detail(snack_category_name, snack_detail_name) values ('달달한', '카라멜 팝콘');
insert into snack_detail(snack_category_name, snack_detail_name) values ('훈제한', '훈제 닭다리');
insert into snack_detail(snack_category_name, snack_detail_name) values ('훈제한', '소시지');
insert into snack_detail(snack_category_name, snack_detail_name) values ('훈제한', '핫바');
insert into snack_detail(snack_category_name, snack_detail_name) values ('훈제한', '불고기맛 후랑크 핫바');
insert into snack_detail(snack_category_name, snack_detail_name) values ('훈제한', '의성 마늘 프랑크 소시지');
insert into snack_detail(snack_category_name, snack_detail_name) values ('훈제한', '훈제 연어');
insert into snack_detail(snack_category_name, snack_detail_name) values ('훈제한', '훈제 오리');
insert into snack_detail(snack_category_name, snack_detail_name) values ('담백한', '천하장사 소시지');
insert into snack_detail(snack_category_name, snack_detail_name) values ('담백한', '키스틱 소시지');
insert into snack_detail(snack_category_name, snack_detail_name) values ('담백한', '비비고 만두');
insert into snack_detail(snack_category_name, snack_detail_name) values ('담백한', '편육');
insert into snack_detail(snack_category_name, snack_detail_name) values ('담백한', '두부 김치');
insert into snack_detail(snack_category_name, snack_detail_name) values ('담백한', '꾸이맨');
insert into snack_detail(snack_category_name, snack_detail_name) values ('담백한', '먹태');
insert into snack_detail(snack_category_name, snack_detail_name) values ('담백한', '순대');
insert into snack_detail(snack_category_name, snack_detail_name) values ('담백한', '알새우칩');


insert into snack_category(beer_category, snack_category_name) values('라거', '짭잘한');
insert into snack_category(beer_category, snack_category_name) values('라거', '고소한');
insert into snack_category(beer_category, snack_category_name) values('라거', '기름진');
insert into snack_category(beer_category, snack_category_name) values('라들러/RTD', '기름진');
insert into snack_category(beer_category, snack_category_name) values('라들러/RTD', '자극적인');
insert into snack_category(beer_category, snack_category_name) values('밀맥주', '고소한');
insert into snack_category(beer_category, snack_category_name) values('밀맥주', '담백한');
insert into snack_category(beer_category, snack_category_name) values('밀맥주', '새콤한');
insert into snack_category(beer_category, snack_category_name) values('스타우트', '자극적인');
insert into snack_category(beer_category, snack_category_name) values('스타우트', '달달한');
insert into snack_category(beer_category, snack_category_name) values('에일', '훈제한');
insert into snack_category(beer_category, snack_category_name) values('에일', '짭잘한');


update beer set beer_image = 'gooseisland_ipa' where beer_name='구스 아일랜드 IPA';
update beer set beer_image = 'guinness_original' where beer_name='기네스 오리지널';
update beer set beer_image = 'desperados_original' where beer_name='데스페라도스 오리지널';
update beer set beer_image = 'miller_genuine_draft' where beer_name='밀러 제뉴인 드래프트';
update beer set beer_image = 'budweiser' where beer_name='버드와이저';
update beer set beer_image = 'bluemoon' where beer_name='블루문';
update beer set beer_image = 'sanmiguel_palepilsen	' where beer_name='산 미겔 페일 필젠';
update beer set beer_image = 'gompyo_wheatbeer' where beer_name='곰표 밀맥주';
update beer set beer_image = 'stella_artois' where beer_name='스텔라 아루투아';
update beer set beer_image = 'somersby_cider' where beer_name='써머스비 사이다';
update beer set beer_image = 'asahi_superdry' where beer_name='아사히 슈퍼드라이';
update beer set beer_image = 'edelweiss' where beer_name='에델바이스';
update beer set beer_image = 'egger_zitronen_radler' where beer_name='예거 레몬 라들러';
update beer set beer_image = 'jeju_wit_ale' where beer_name='제주 위트 에일';
update beer set beer_image = 'tsingtao' where beer_name='칭따오';
update beer set beer_image = 'cass_light' where beer_name='카스 라이트';
update beer set beer_image = 'cass_fresh' where beer_name='카스 후레시';
update beer set beer_image = 'cafri' where beer_name='카프리';
update beer set beer_image = 'carlsberg_danish_pilsner' where beer_name='칼스버그 대니쉬 필스너';
update beer set beer_image = 'bigwave_golden_ale' where beer_name='코나 빅 웨이브 골든에일';
update beer set beer_image = 'kozel_dark ' where beer_name='코젤 다크';
update beer set beer_image = 'kronenbourg_1664_blanc' where beer_name='크로넨버그 1664 블랑';
update beer set beer_image = 'kloud_draft' where beer_name='클라우드 생드리프트';
update beer set beer_image = 'tiger' where beer_name='타이거';
update beer set beer_image = 'tiger_radler_lemon' where beer_name='타이거 라들러 레몬';
update beer set beer_image = 'tiger_radler_grapefruit' where beer_name='타이거 라들러 자몽';
update beer set beer_image = 'terra' where beer_name='테라';
update beer set beer_image = 'paulaner_weissbier' where beer_name='파울라너 뮌헨 라거';
update beer set beer_image = 'paulaner_munchnerhell' where beer_name='파울라너 바이스비어 둔켈';
update beer set beer_image = 'fitz_superclear' where beer_name='피츠 수퍼클리어';
update beer set beer_image = 'pilsner_urquell' where beer_name='필스너 우르켈';
update beer set beer_image = 'heineken_lager' where beer_name='하이네켄 라거';
update beer set beer_image = 'hite_extra_cold' where beer_name='하이트 엑스트라 콜드';
update beer set beer_image = 'hanmac' where beer_name='한맥';
update beer set beer_image = 'hoegaarden' where beer_name='호가든';
update beer set beer_image = 'hoegaarden_rose' where beer_name='호가든 로제';
update beer set beer_image = 'egger_pfirsich_radler' where beer_name='예거 복숭아 라들러';

update snack_detail set snack_image= 'ppoca'where snack_detail_name='포카칩';
update snack_detail set snack_image= 'noongamza'where snack_detail_name='눈을 감자';
update snack_detail set snack_image= 'dodohan'where snack_detail_name='도도한 나쵸';
update snack_detail set snack_image= 'maesae'where snack_detail_name='매운 새우깡';
update snack_detail set snack_image= 'squid_shortleg'where snack_detail_name='오징어 숏다리';
update snack_detail set snack_image= 'string_cheese'where snack_detail_name='스트링치즈';
update snack_detail set snack_image= 'oging_ddangkong'where snack_detail_name='오징어 땅콩';
update snack_detail set snack_image= 'marrun_oging'where snack_detail_name='오징어';
update snack_detail set snack_image= 'cornchip'where snack_detail_name='콘칩';
update snack_detail set snack_image= 'pretzel'where snack_detail_name='프레젤';
update snack_detail set snack_image= 'guipo'where snack_detail_name='쥐포';
update snack_detail set snack_image= 'postick'where snack_detail_name='포스틱';
update snack_detail set snack_image= 'popcorn'where snack_detail_name='팝콘';
update snack_detail set snack_image= 'honey_butter_almond'where snack_detail_name='허니버터 아몬드';
update snack_detail set snack_image= 'nut'where snack_detail_name='견과류';
update snack_detail set snack_image= 'ggubuk_corn_soup'where snack_detail_name='꼬북칩';
update snack_detail set snack_image= 'nacho'where snack_detail_name='나쵸';
update snack_detail set snack_image= 'cracker'where snack_detail_name='크래커';
update snack_detail set snack_image= 'ziller_beef_jerky'where snack_detail_name='육포';
update snack_detail set snack_image= 'peanut'where snack_detail_name='땅콩';
update snack_detail set snack_image= 'tuna_cracker'where snack_detail_name='참치크래커';
update snack_detail set snack_image= 'coffe_peanut'where snack_detail_name='커피땅콩';
update snack_detail set snack_image= 'maekbansuk'where snack_detail_name='맥반석 오징어';
update snack_detail set snack_image= 'chicken_gangjung'where snack_detail_name='닭강정';
update snack_detail set snack_image= 'pizza'where snack_detail_name='피자';
update snack_detail set snack_image= 'jockbal'where snack_detail_name='족발';
update snack_detail set snack_image= 'hamburger'where snack_detail_name='햄버거';
update snack_detail set snack_image= 'corn_cheese_gratin'where snack_detail_name='콘치즈 그라탕';
update snack_detail set snack_image= 'tteokk_bokk'where snack_detail_name='떡볶이';
update snack_detail set snack_image= 'gangjeong'where snack_detail_name='치킨강정';
update snack_detail set snack_image= 'odeng'where snack_detail_name='얼큰한 오뎅';
update snack_detail set snack_image= 'udong_bokk'where snack_detail_name='우동볶이';
update snack_detail set snack_image= 'cub_ramen'where snack_detail_name='컵라면';
update snack_detail set snack_image= 'chicken_feet'where snack_detail_name='닭발';
update snack_detail set snack_image= 'chicken_kko'where snack_detail_name='닭꼬치';
update snack_detail set snack_image= 'kielbasa'where snack_detail_name='킬바사 소세지';
update snack_detail set snack_image= 'anzuya_duru'where snack_detail_name='안주야 매콤두루치기';
update snack_detail set snack_image= 'odol_bone'where snack_detail_name='오돌뼈';
update snack_detail set snack_image= 'fire_mak'where snack_detail_name='불막창';
update snack_detail set snack_image= 'gob_bokk'where snack_detail_name='곱창볶음';
update snack_detail set snack_image= 'bokk_soon'where snack_detail_name='볶음 순대';
update snack_detail set snack_image= 'apple'where snack_detail_name='사과';
update snack_detail set snack_image= 'pineapple'where snack_detail_name='파인애플';
update snack_detail set snack_image= 'peach'where snack_detail_name='황도/백도';
update snack_detail set snack_image= 'fruit_cocktail'where snack_detail_name='후르츠 칵테일';
update snack_detail set snack_image= 'paldo'where snack_detail_name='비빔면';
update snack_detail set snack_image= 'zzol_myeon'where snack_detail_name='쫄면';
update snack_detail set snack_image= 'cajun_salad'where snack_detail_name='케이준 치킨 샐러드';
update snack_detail set snack_image= 'fruit_mix'where snack_detail_name='과일믹스';
update snack_detail set snack_image= 'homerun_ball'where snack_detail_name='홈런볼';
update snack_detail set snack_image= 'haribo_jelly'where snack_detail_name='하리보젤리';
update snack_detail set snack_image= 'honey_butter'where snack_detail_name='허니버터칩';
update snack_detail set snack_image= 'kkobuk_choco'where snack_detail_name='꼬북칩 초코';
update snack_detail set snack_image= 'banana_kick'where snack_detail_name='바나나킥';
update snack_detail set snack_image= 'choco'where snack_detail_name='초콜렛';
update snack_detail set snack_image= 'corn_cho'where snack_detail_name='콘초';
update snack_detail set snack_image= 'cara_popcorn'where snack_detail_name='카라멜 팝콘';
update snack_detail set snack_image='sousage' where snack_detail_name='소시지';
update snack_detail set snack_image='garlic_hotbar' where snack_detail_name='의성 마늘 프랑크 소시지';
update snack_detail set snack_image='hotbar' where snack_detail_name='핫바';
update snack_detail set snack_image='smoked_drumstick' where snack_detail_name='훈제 닭다리';
update snack_detail set snack_image='smoked_salmon' where snack_detail_name='훈제 연어';
update snack_detail set snack_image='smoked_duck' where snack_detail_name='훈제 오리';
update snack_detail set snack_image='ccuiman' where snack_detail_name='꾸이맨';
update snack_detail set snack_image='dubu_kimchi' where snack_detail_name='두부 김치';
update snack_detail set snack_image='muktae' where snack_detail_name='먹태';
update snack_detail set snack_image='bibigo' where snack_detail_name='비비고 만두';
update snack_detail set snack_image='soondae' where snack_detail_name='순대';
update snack_detail set snack_image='shrimpchip' where snack_detail_name='알새우칩';
update snack_detail set snack_image='jangsa' where snack_detail_name='천하장사 소시지';
update snack_detail set snack_image='kistick' where snack_detail_name='키스틱 소시지';
update snack_detail set snack_image='jjolgit' where snack_detail_name='편육';
update snack_detail set snack_image='bulgogi_hatbar' where snack_detail_name='불고기맛 후랑크 핫바';







