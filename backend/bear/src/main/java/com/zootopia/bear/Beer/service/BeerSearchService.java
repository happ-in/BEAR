package com.zootopia.bear.Beer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zootopia.bear.Beer.domain.Beer;
import com.zootopia.bear.Beer.dto.BeerHashTagDto;
import com.zootopia.bear.Beer.repository.BeerRepository;
import com.zootopia.bear.HashTag.dto.HashTagTotalDto;
import com.zootopia.bear.HashTag.repository.HashTagRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BeerSearchService {
	private final BeerRepository beerRepository;
	private final HashTagRepository hashTagRepository;

	public BeerHashTagDto beerSearch(int beerId) {
		Beer beer = beerRepository.findById(beerId).orElseThrow(NullPointerException::new);
		List<HashTagTotalDto> hashTagTotalDtos = hashTagRepository.searchHashTagToTal(beerId);
		return new BeerHashTagDto(beer, hashTagTotalDtos);
	}
}
