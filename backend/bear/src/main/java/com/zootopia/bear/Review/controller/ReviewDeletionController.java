package com.zootopia.bear.Review.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zootopia.bear.Review.service.ReviewDeletionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/review")
@RequiredArgsConstructor
public class ReviewDeletionController {

	private final ReviewDeletionService reviewDeletionService;

	@DeleteMapping
	public ResponseEntity<?> reviewDeletion(@RequestParam int reviewId) {
		reviewDeletionService.reviewDeletion(reviewId);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
}
