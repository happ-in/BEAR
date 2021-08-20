package com.zootopia.bear.Beer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zootopia.bear.Beer.domain.Beer;
import com.zootopia.bear.Beer.dto.BeerHashTagDto;
import com.zootopia.bear.Beer.repository.BeerRepository;
import com.zootopia.bear.HashTag.dto.HashTagTotalDto;
import com.zootopia.bear.HashTag.repository.HashTagRepository;
import com.zootopia.bear.Review.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BeerSearchService {
	private final BeerRepository beerRepository;
	private final ReviewRepository reviewRepository;
	private final HashTagRepository hashTagRepository;

	public BeerHashTagDto beerSearch(int beerId) {
		Beer beer = beerRepository.findById(beerId);
		double beerAvg = reviewRepository.beerAvg(beerId).orElse(0.0);
		List<HashTagTotalDto> hashTagTotalDtos = hashTagRepository.searchHashTagToTal(beerId);
		return new BeerHashTagDto(beer, beerAvg, hashTagTotalDtos);
	}

	public BeerHashTagDto beerSearch(String searchId) {
		Beer beer = beerRepository.findBySearchId(searchId);
		double beerAvg = reviewRepository.beerAvg(beer.getBeerId()).orElse(0.0);
		List<HashTagTotalDto> hashTagTotalDtos = hashTagRepository.searchHashTagToTal(beer.getBeerId());
		return new BeerHashTagDto(beer, beerAvg, hashTagTotalDtos);
	}

	public List<Beer> beerSearchByHashTag(int hashTagId) {
		return beerRepository.findByHashTag(hashTagId);
	}
}
