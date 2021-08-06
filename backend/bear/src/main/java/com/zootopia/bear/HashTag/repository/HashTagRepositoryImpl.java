package com.zootopia.bear.HashTag.repository;

import static com.zootopia.bear.HashTag.domain.QHashTag.hashTag;
import static com.zootopia.bear.HashTag.domain.QReviewHashTag.reviewHashTag;

import com.zootopia.bear.HashTag.dto.HashTagNameDto;

import java.util.List;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HashTagRepositoryImpl implements HashTagRepositoryCustom {
	private final JPAQueryFactory queryFactory;

	public List<HashTagNameDto> searchHashTagTop4(int beerId) {
		return queryFactory
			.select(Projections.constructor(HashTagNameDto.class,
				hashTag.hashTagName))
			.from(reviewHashTag)
			.leftJoin(hashTag)
			.on(reviewHashTag.hashTag.hashTagId.eq(hashTag.hashTagId))
			.where(reviewHashTag.beerId.eq(beerId))
			.groupBy(reviewHashTag.beerId, reviewHashTag.hashTag)
			.orderBy(reviewHashTag.count().desc())
			.limit(4)
			.fetch();
	}
}
