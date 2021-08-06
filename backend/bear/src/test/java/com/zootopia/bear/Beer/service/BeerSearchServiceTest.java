package com.zootopia.bear.Beer.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.zootopia.bear.Beer.domain.Beer;
import com.zootopia.bear.Beer.repository.BeerRepository;
import com.zootopia.bear.HashTag.domain.ReviewHashTag;
import com.zootopia.bear.HashTag.dto.HashTagTotalDto;
import com.zootopia.bear.HashTag.repository.HashTagRepository;
import com.zootopia.bear.HashTag.repository.ReviewHashTagRepository;

@SpringBootTest
class BeerSearchServiceTest {

	@Autowired private BeerRepository repository;
	@Autowired private ReviewHashTagRepository reviewHashTagRepository;
	@Autowired private HashTagRepository hashTagRepository;

	@Test
	public void beerTest() {
		Beer beer = repository.findById(1).get();

	}

	@Test
	public void tagTest() {
		List<HashTagTotalDto> hashTagTotalDtos = hashTagRepository.searchHashTagToTal(1);
		for (HashTagTotalDto hashTagTotalDto : hashTagTotalDtos) {
			System.out.println(hashTagTotalDto.getHashTagName() + " : " + hashTagTotalDto.getTotal() + "개");
		}
	}
}