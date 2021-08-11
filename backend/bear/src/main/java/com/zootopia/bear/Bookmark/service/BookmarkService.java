package com.zootopia.bear.Bookmark.service;

import com.zootopia.bear.Bookmark.domain.Bookmark;
import com.zootopia.bear.Bookmark.domain.BookmarkId;
import com.zootopia.bear.Bookmark.repository.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookmarkService {
    private final BookmarkRepository bookmarkRepository;

    @Autowired
    public BookmarkService(BookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }

    public void addBookmark(Long userId,int beerId) {
        BookmarkId bookmarkId = new BookmarkId(userId,beerId);
        Bookmark bookmark = new Bookmark(bookmarkId);
        bookmarkRepository.save(bookmark);
    }

    public void deleteBookmark(Long userId,int beerId) {
        BookmarkId bookmarkId = new BookmarkId(userId,beerId);
        Bookmark bookmark = new Bookmark(bookmarkId);
        bookmarkRepository.deleteById(bookmarkId);
    }


}
