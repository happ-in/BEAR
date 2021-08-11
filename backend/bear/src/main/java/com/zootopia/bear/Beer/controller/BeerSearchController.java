package com.zootopia.bear.Beer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zootopia.bear.Beer.dto.BeerHashTagDto;
import com.zootopia.bear.Beer.service.BeerSearchService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/beer")
@RequiredArgsConstructor
public class BeerSearchController {

	private final BeerSearchService beerSearchService;

	@GetMapping
	public ResponseEntity<?> beerSearch(@RequestParam int beerId) {
		BeerHashTagDto beerHashTagDto = beerSearchService.beerSearch(beerId);
		return ResponseEntity.ok(beerHashTagDto);
	}
}
