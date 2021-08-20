package com.zootopia.bear.Review.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zootopia.bear.Review.dto.ReviewLikeDto;
import com.zootopia.bear.Review.service.ReviewLikeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/review/like")
@RequiredArgsConstructor
public class ReviewLikeController {

	private final ReviewLikeService reviewLikeService;

	@PostMapping
	public ResponseEntity<?> reviewLike(@Valid @RequestBody ReviewLikeDto reviewLikeDto) {
		reviewLikeService.reviewLike(reviewLikeDto);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<?> reviewDislike(@Valid @RequestBody ReviewLikeDto reviewLikeDto) {
		reviewLikeService.reviewDislike(reviewLikeDto);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
}
