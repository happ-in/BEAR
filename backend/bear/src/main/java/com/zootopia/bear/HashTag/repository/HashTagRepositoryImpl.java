package com.zootopia.bear.HashTag.repository;

import static com.zootopia.bear.HashTag.domain.QHashTag.hashTag;
import static com.zootopia.bear.HashTag.domain.QReviewHashTag.reviewHashTag;

import com.zootopia.bear.HashTag.dto.HashTagNameDto;

import java.util.List;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.zootopia.bear.HashTag.dto.HashTagTotalDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HashTagRepositoryImpl implements HashTagRepositoryCustom {
	private final JPAQueryFactory queryFactory;

	@Override
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

	@Override
	public List<HashTagTotalDto> searchHashTagToTal(int beerId) {
		return queryFactory
			.select(Projections.constructor(HashTagTotalDto.class,
				hashTag.hashTagId,
				hashTag.hashTagName,
				reviewHashTag.count().as("total")))
			.from(reviewHashTag)
			.leftJoin(hashTag)
			.on(reviewHashTag.hashTag.hashTagId.eq(hashTag.hashTagId))
			.where(reviewHashTag.beerId.eq(beerId))
			.groupBy(reviewHashTag.beerId, reviewHashTag.hashTag)
			.orderBy(reviewHashTag.count().desc())
			.fetch();
	}
}
