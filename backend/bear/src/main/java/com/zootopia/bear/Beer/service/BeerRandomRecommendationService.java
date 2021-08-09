package com.zootopia.bear.Beer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zootopia.bear.Beer.domain.Beer;
import com.zootopia.bear.Beer.dto.BeerRandomRecommendationDto;
import com.zootopia.bear.Beer.repository.BeerRepository;
import com.zootopia.bear.Country.domain.Country;
import com.zootopia.bear.HashTag.dto.HashTagNameDto;
import com.zootopia.bear.HashTag.repository.HashTagRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BeerRandomRecommendationService {

	private final BeerRepository beerRepository;
	private final HashTagRepository hashTagRepository;

	public BeerRandomRecommendationDto beerRandomRecommendation() {
		Beer beer = beerRepository.searchRandomBeer();
		Country country = beer.getCountry();
		List<HashTagNameDto> hashTagNameDtos = hashTagRepository.searchHashTagTop4(beer.getBeerId());
		return new BeerRandomRecommendationDto(beer, hashTagNameDtos);
	}
}
