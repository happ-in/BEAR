package com.zootopia.bear.Follow.controller;




import com.zootopia.bear.Follow.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequestMapping("/follower")
@RestController
public class FollowController {
    private final FollowService followService;

    @Autowired
    public FollowController(FollowService followService) {
        this.followService = followService;
    }

    @PostMapping("/addFollow")
    public ResponseEntity<?> addFollow(HttpSession session, @RequestParam(name = "followUserId") long followUserId){
        long userId = (long) session.getAttribute("userId");
        followService.addFollowUser(userId,followUserId);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping("/deleteFollow")
    public ResponseEntity<?> deleteFollow(HttpSession session, @RequestParam(name = "followUserId") long followUserId){
        long userId = (long) session.getAttribute("userId");
        followService.deleteFollowUser(userId,followUserId);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
