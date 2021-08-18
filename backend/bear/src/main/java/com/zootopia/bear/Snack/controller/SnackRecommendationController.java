package com.zootopia.bear.Snack.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zootopia.bear.Snack.dto.SnackRecommendationDto;
import com.zootopia.bear.Snack.service.SnackRecommendationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/snack")
@RequiredArgsConstructor
public class SnackRecommendationController {

	private final SnackRecommendationService snackRecommendationService;

	@GetMapping
	public ResponseEntity<?> snackRecommendation(@RequestParam String beerCategory) {
		SnackRecommendationDto snackRecommendation = snackRecommendationService.SnackRecommendation(beerCategory);
		return ResponseEntity.ok(snackRecommendation);
	}
}
