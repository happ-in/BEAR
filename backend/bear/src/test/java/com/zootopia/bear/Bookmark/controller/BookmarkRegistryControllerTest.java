package com.zootopia.bear.Bookmark.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.zootopia.bear.Bookmark.service.BookmarkService;

@SpringBootTest
class BookmarkRegistryControllerTest {

	@Autowired
	private BookmarkService bookmarkService;

	@Test
	public void 테스트() {
		long userId = 1847933666L;
		int beerId = 2;

		boolean flag = bookmarkService.isBookmark(userId, beerId);
		System.out.println(flag);
	}
}