package com.zootopia.bear.Review.controller;

import javax.validation.Valid;

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
@RequestMapping(value = "/review")
@RequiredArgsConstructor
public class ReviewRegistryController {

	private final ReviewRegistryService reviewRegistryService;

	@PostMapping
	public ResponseEntity<?> reviewRegistry(@Valid @RequestBody ReviewRegistryDto reviewRegistryDto) {
		reviewRegistryService.reviewRegistry(reviewRegistryDto);
		return ResponseEntity.ok(true);
	}

	@PutMapping
	public ResponseEntity<?> reviewUpdate(@Valid @RequestBody ReviewUpdateDto reviewUpdateDto) {
		reviewRegistryService.reviewUpdate(reviewUpdateDto);
		return ResponseEntity.ok(true);
	}
}
