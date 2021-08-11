package com.zootopia.bear.Follower.controller;



import com.zootopia.bear.Follower.dto.FollowDto;
import com.zootopia.bear.Follower.service.FollowerService;
import com.zootopia.bear.User.domain.User;
import com.zootopia.bear.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/follower")
@RestController
public class FollowController {
    private final FollowerService followService;
    private final UserService userService;

    @Autowired
    public FollowController(FollowerService followService,UserService userService) {
        this.followService = followService;
        this.userService = userService;
    }

    @GetMapping("/follows")
    public ResponseEntity<?> getFollows(HttpSession session){
        Long userId = (Long) session.getAttribute("userId");
        List<Long> followList = followService.getFollowList(userId);
        return getResponseEntity(followList);
    }

    @GetMapping("/followers")
    public ResponseEntity<?> getFollowers(HttpSession session){
        Long followUserId = (Long) session.getAttribute("userId");
        List<Long> followerList = followService.getFollowerList(followUserId);
        return getResponseEntity(followerList);
    }

    private ResponseEntity<?> getResponseEntity(List<Long> list) {
        List<FollowDto> followList = new ArrayList<>();
        for(Long followId : list){
            User user =  userService.getUser(followId).get();
            followList.add(new FollowDto(followId, user.getNickname()));
        }
        return new ResponseEntity<>(followList, HttpStatus.OK);
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
