package com.zootopia.bear.Follower.controller;



import com.zootopia.bear.Follower.service.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/follower")
@RestController
public class FollowController {
    private final FollowerService followService;

    @Autowired
    public FollowController(FollowerService followService) {
        this.followService = followService;
    }

    @GetMapping("/follows")
    public ResponseEntity<?> getFollows(HttpSession session){
        Long user_id = (Long) session.getAttribute("userId");
        List<Long> followList = followService.getFollowList(user_id);
        return new ResponseEntity<>(followList, HttpStatus.OK);
    }

    @GetMapping("/followers")
    public ResponseEntity<?> getFollowers(HttpSession session){
        Long followUserId = (Long) session.getAttribute("userId");
        List<Long> followerList = followService.getFollowerList(followUserId);
        return new ResponseEntity<>(followerList, HttpStatus.OK);
    }

    @PostMapping("/addFollow")
    public ResponseEntity<?> addFollow(HttpSession session, @RequestParam(name = "followUserId") Long followUserId){
        Long userId = (Long) session.getAttribute("userId");
        followService.addFollowUser(userId,followUserId);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping("/deleteFollow")
    public ResponseEntity<?> deleteFollow(HttpSession session, @RequestParam(name = "followUserId") Long followUserId){
        Long userId = (Long) session.getAttribute("userId");
        followService.deleteFollowUser(userId,followUserId);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
