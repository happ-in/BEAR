package com.zootopia.bear.Beer.repository;

import static com.zootopia.bear.Beer.domain.QBeer.beer;
import static com.zootopia.bear.Bookmark.domain.QBookmark.*;
import static com.zootopia.bear.Review.domain.QReview.review;
import static com.zootopia.bear.utils.StringUtils.RANK_LIMIT;

import java.util.List;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.zootopia.bear.Bookmark.domain.QBookmark;
import com.zootopia.bear.Rank.dto.RankDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BeerRepositoryImpl implements BeerRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	@Override
	public List<RankDto> rankAll() {
		return queryFactory
			.select(Projections.constructor(RankDto.class,
				beer.beerId,
				beer.beerName,
				beer.country.CountryName,
				beer.beerCategory,
				beer.alcoholProof,
				beer.beerImage,
				beer.count().as("totalCount")))
			.from(beer)
			.join(bookmark)
			.on(beer.beerId.eq(bookmark.beer.beerId))
			.groupBy(beer.beerId)
			.orderBy(beer.count().desc())
			.limit(RANK_LIMIT)
			.fetch();
	}

	@Override
	public List<RankDto> rankByCategory(String category) {
		return queryFactory
			.select(Projections.constructor(RankDto.class,
				beer.beerId,
				beer.beerName,
				beer.country.CountryName,
				beer.beerCategory,
				beer.alcoholProof,
				beer.beerImage,
				beer.count().as("totalCount")))
			.from(beer)
			.join(bookmark)
			.on(beer.beerId.eq(bookmark.beer.beerId))
			.where(beer.beerCategory.contains(category))
			.groupBy(beer.beerId)
			.orderBy(beer.count().desc())
			.limit(RANK_LIMIT)
			.fetch();
	}
}
