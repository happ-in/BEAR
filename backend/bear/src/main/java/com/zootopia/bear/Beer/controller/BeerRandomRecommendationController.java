package com.zootopia.bear.Beer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zootopia.bear.Beer.dto.BeerRandomRecommendationDto;
import com.zootopia.bear.Beer.service.BeerRandomRecommendationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/beer/random")
@RequiredArgsConstructor
public class BeerRandomRecommendationController {

	private final BeerRandomRecommendationService beerRandomRecommendationService;

	@GetMapping
	public ResponseEntity<?> beerRandomRecommendation() {
		BeerRandomRecommendationDto beerRandomRecommendationDto = beerRandomRecommendationService.beerRandomRecommendation();
		return ResponseEntity.ok(beerRandomRecommendationDto);
	}
}
