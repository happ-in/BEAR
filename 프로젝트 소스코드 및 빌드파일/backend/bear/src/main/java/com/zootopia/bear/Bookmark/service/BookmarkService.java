package com.zootopia.bear.Bookmark.service;

import com.zootopia.bear.Beer.repository.BeerRepository;
import com.zootopia.bear.Bookmark.domain.Bookmark;
import com.zootopia.bear.Bookmark.domain.BookmarkId;
import com.zootopia.bear.Bookmark.repository.BookmarkRepository;
import com.zootopia.bear.User.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookmarkService {
	private final BookmarkRepository bookmarkRepository;
	private final UserRepository userRepository;
	private final BeerRepository beerRepository;

	public void addBookmark(long userId, int beerId) {
		BookmarkId bookmarkId = new BookmarkId(userId, beerId);
		Bookmark bookmark = new Bookmark(bookmarkId, userRepository.getById(userId), beerRepository.getById(beerId));
		bookmarkRepository.save(bookmark);
	}

	public void deleteBookmark(long userId, int beerId) {
		BookmarkId bookmarkId = new BookmarkId(userId, beerId);
		bookmarkRepository.deleteById(bookmarkId);
	}

	public boolean isBookmark(long userId, int beerId) {
		return bookmarkRepository.findById(new BookmarkId(userId, beerId)).isPresent();
	}

}
