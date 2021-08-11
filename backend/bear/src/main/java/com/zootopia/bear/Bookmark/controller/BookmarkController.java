package com.zootopia.bear.Bookmark.controller;

import com.zootopia.bear.Bookmark.service.BookmarkService;

public class BookmarkController {
    private final BookmarkService bookmarkService;

    public BookmarkController(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }
}
