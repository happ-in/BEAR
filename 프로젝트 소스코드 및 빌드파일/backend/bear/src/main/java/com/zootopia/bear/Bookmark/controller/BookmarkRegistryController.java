package com.zootopia.bear.Bookmark.controller;

import com.zootopia.bear.Bookmark.dto.BookmarkDto;
import com.zootopia.bear.Bookmark.service.BookmarkService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookmark")
public class BookmarkRegistryController {
	private final BookmarkService bookmarkService;

	public BookmarkRegistryController(BookmarkService bookmarkService) {
		this.bookmarkService = bookmarkService;
	}

	@PostMapping
	public ResponseEntity<?> addBookmark(@RequestBody BookmarkDto bookmarkDto) {
		long userId = bookmarkDto.getUserId();
		int beerId = bookmarkDto.getBeerId();
		bookmarkService.addBookmark(userId, beerId);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<?> deleteBookmark(@RequestBody BookmarkDto bookmarkDto) {
		long userId = bookmarkDto.getUserId();
		int beerId = bookmarkDto.getBeerId();
		bookmarkService.deleteBookmark(userId, beerId);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<?> isBookmark(@RequestParam long userId, @RequestParam int beerId) {
		return ResponseEntity.ok().body(bookmarkService.isBookmark(userId, beerId));
	}
}
