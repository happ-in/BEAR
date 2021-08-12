package com.zootopia.bear.Bookmark.controller;

import com.zootopia.bear.Bookmark.service.BookmarkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/bookmark")
public class BookmarkRegistryController {
    private final BookmarkService bookmarkService;

    public BookmarkRegistryController(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

    @PostMapping
    public ResponseEntity<?> addBookmark(@RequestParam int beerId, HttpSession session) {
        long userId = (long) session.getAttribute("userId");
        bookmarkService.addBookmark(userId,beerId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteBookmark(@RequestParam int beerId, HttpSession session) {
        long userId = (long) session.getAttribute("userId");
        bookmarkService.deleteBookmark(userId,beerId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
