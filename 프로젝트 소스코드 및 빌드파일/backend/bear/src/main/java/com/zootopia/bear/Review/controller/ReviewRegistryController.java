package com.zootopia.bear.Review.controller;

import javax.validation.Valid;

import com.zootopia.bear.Badge.service.UserBadgeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zootopia.bear.Review.dto.ReviewRegistryDto;
import com.zootopia.bear.Review.dto.ReviewUpdateDto;
import com.zootopia.bear.Review.service.ReviewRegistryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/review")
@RequiredArgsConstructor
public class ReviewRegistryController {

	private final ReviewRegistryService reviewRegistryService;
	private final UserBadgeService userBadgeService;

	@PostMapping
	public ResponseEntity<?> reviewRegistry(@Valid @RequestBody ReviewRegistryDto reviewRegistryDto) {
		long userId = reviewRegistryDto.getUserId();
		userBadgeService.addColumbusBadge(userId, reviewRegistryDto.getBeerId());
		reviewRegistryService.reviewRegistry(reviewRegistryDto);
		userBadgeService.addAngelBadge(userId);
		userBadgeService.addDevilBadge(userId);
		return ResponseEntity.ok(true);
	}

	@PutMapping
	public ResponseEntity<?> reviewUpdate(@Valid @RequestBody ReviewUpdateDto reviewUpdateDto) {
		reviewRegistryService.reviewUpdate(reviewUpdateDto);
		return ResponseEntity.ok(true);
	}
}
