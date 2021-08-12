package com.zootopia.bear.Badge.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/badge")
public class BadgeRegistryController {

    @GetMapping
    public ResponseEntity<?> checkBadge(HttpSession session){
        Long userId = (Long) session.getAttribute("userId");
        return null;
    }
}
