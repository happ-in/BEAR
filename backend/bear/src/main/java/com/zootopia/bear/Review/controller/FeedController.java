package com.zootopia.bear.Review.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zootopia.bear.Review.dto.ReviewDto;
import com.zootopia.bear.Review.service.ReviewSearchService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/feed")
@RequiredArgsConstructor
public class FeedController {

	private final ReviewSearchService reviewSearchService;

	@GetMapping
	public ResponseEntity<?> FeedSearch(@RequestParam long userId) {
		List<ReviewDto> reviewDtos = reviewSearchService.feed(userId);
		return ResponseEntity.ok().body(reviewDtos);
	}
}
