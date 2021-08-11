package com.zootopia.bear.Bookmark.controller;

import com.zootopia.bear.Bookmark.service.BookmarkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/bookmark")
public class BookmarkController {
    private final BookmarkService bookmarkService;

    public BookmarkController(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

    @GetMapping("/add")
    public ResponseEntity<?> addBookmark(@RequestParam int beerId, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        bookmarkService.addBookmark(userId,beerId);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/delete")
    public ResponseEntity<?> deleteBookmark(@RequestParam int beerId, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        bookmarkService.deleteBookmark(userId,beerId);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
