package com.zootopia.bear.Search.controller;

import com.zootopia.bear.Follower.dto.FollowDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zootopia.bear.Search.service.SearchService;

import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {

	private final SearchService searchService;

	@GetMapping("/hashtag")
	public ResponseEntity<?> searchHashTag(@RequestParam String keyword) {
		return new ResponseEntity<>(searchService.searchHashTag(keyword), HttpStatus.OK);
	}

	@GetMapping("/beer")
	public ResponseEntity<?> searchBeer(@RequestParam String keyword) {
		return new ResponseEntity<>(searchService.searchBeer(keyword), HttpStatus.OK);
	}

	@GetMapping("/bookmark")
	public ResponseEntity<?> searchBookmark(HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		return new ResponseEntity<>(searchService.searchBookmark(userId),HttpStatus.OK);
	}

	@GetMapping("/badge")
	public ResponseEntity<?> searchBadge(){

		return null;
	}

	@GetMapping("/follows")
	public ResponseEntity<?> getFollows(HttpSession session){
		Long userId = (Long) session.getAttribute("userId");
		List<FollowDto> followList = searchService.getFollowList(userId);
		return new ResponseEntity<>(followList,HttpStatus.OK);
	}

	@GetMapping("/followers")
	public ResponseEntity<?> getFollowers(HttpSession session){
		Long followUserId = (Long) session.getAttribute("userId");
		List<FollowDto> followerList = searchService.getFollowerList(followUserId);
		return new ResponseEntity<>(followerList,HttpStatus.OK);
	}

}
