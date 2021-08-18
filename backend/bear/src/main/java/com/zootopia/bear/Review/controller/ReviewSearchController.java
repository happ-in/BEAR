package com.zootopia.bear.Review.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zootopia.bear.Review.dto.ReviewDto;
import com.zootopia.bear.Review.service.ReviewSearchService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/review")
@RequiredArgsConstructor
public class ReviewSearchController {

	private final ReviewSearchService reviewSearchService;

	@GetMapping
	public ResponseEntity<?> MyReviewSearch(@RequestParam long userId) {
		List<ReviewDto> reviewDtoList = reviewSearchService.searchMyReview(userId);
		return new ResponseEntity<>(reviewDtoList, HttpStatus.OK);
	}

	@GetMapping("/other")
	public ResponseEntity<?> OtherReviewSearch(@RequestParam long otherId, @RequestParam long myId) {
		List<ReviewDto> reviewDtoList = reviewSearchService.searchOtherReview(otherId, myId);
		return new ResponseEntity<>(reviewDtoList, HttpStatus.OK);
	}
}
