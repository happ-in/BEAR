package com.zootopia.bear.Follow.controller;


import com.zootopia.bear.Follow.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequestMapping("/follow")
@RestController
public class FollowController {
    private final FollowService followService;

    @Autowired
    public FollowController(FollowService followService) {
        this.followService = followService;
    }

    @GetMapping("/f1")
    public ResponseEntity<?> testgetFollows(HttpSession session){
        //followService.getFollows();
        return null;
    }

    public ResponseEntity<?> testaddFollow(HttpSession session, @RequestParam(name = "follow_id") Long follow_id){
        Long user_id = (Long) session.getAttribute("user_id");
        followService.addFollow(user_id,follow_id);
        return null;
    }

    public ResponseEntity<?> testdeleteFollow(HttpSession session, @RequestParam(name = "follow_id") Long follow_id){
        Long user_id = (Long) session.getAttribute("user_id");
        followService.deleteFollow(user_id,follow_id);
        return null;
    }
}
