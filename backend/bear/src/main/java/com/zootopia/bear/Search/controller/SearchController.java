package com.zootopia.bear.Search.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zootopia.bear.Search.service.SearchService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/search")
@RequiredArgsConstructor
public class SearchController {

	private final SearchService searchService;

	@GetMapping("/hashtag")
	public ResponseEntity<?> searchHashTag(@RequestParam String keyword) {
		return ResponseEntity.ok().body(searchService.searchHashTag(keyword));
	}

	@GetMapping("/beer")
	public ResponseEntity<?> searchBeer(@RequestParam String keyword) {
		return ResponseEntity.ok().body(searchService.searchBeer(keyword));
	}

	@GetMapping("/user")
	public ResponseEntity<?> searchUser(@RequestParam String keyword) {
		return ResponseEntity.ok().body(searchService.searchUser(keyword));
	}

	@GetMapping("/userInfo")
	public ResponseEntity<?> getMyInfo(@RequestParam long userId) {
		if(searchService.getUser(userId).isPresent()) {
			return new ResponseEntity<>(searchService.getUserInfoDto(userId),HttpStatus.OK);
		}
		return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/bookmark")
	public ResponseEntity<?> searchBookmark(@RequestParam long userId) {
		return new ResponseEntity<>(searchService.searchBookmark(userId),HttpStatus.OK);
	}

	@GetMapping("/follows")
	public ResponseEntity<?> searchFollows(@RequestParam long userId) {
		return new ResponseEntity<>(searchService.getFollowList(userId),HttpStatus.OK);
	}

	@GetMapping("/followers")
	public ResponseEntity<?> searchFollowers(@RequestParam long userId) {
		return new ResponseEntity<>(searchService.getFollowerList(userId),HttpStatus.OK);
	}

	@GetMapping("/badge")
	public ResponseEntity<?> searchBadge(@RequestParam long userId) {
		return new ResponseEntity<>(searchService.getGainBadgeList(userId),HttpStatus.OK);
	}
}
