package com.zootopia.bear.rank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zootopia.bear.Beer.repository.BeerRepository;
import com.zootopia.bear.rank.dto.RankDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RankService {

	private final BeerRepository beerRepository;

	public List<RankDto> rankAll() {
		return beerRepository.rankAll();
	}

	public List<RankDto> rankByCategory(String category) {
		return beerRepository.rankByCategory(category);
	}
}
