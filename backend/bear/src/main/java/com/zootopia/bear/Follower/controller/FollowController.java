package com.zootopia.bear.Follower.controller;




import com.zootopia.bear.Follower.dto.FollowDto;
import com.zootopia.bear.Follower.service.FollowerService;
import com.zootopia.bear.User.service.UserService;
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

    @PostMapping("/addFollow")
    public ResponseEntity<?> addFollow(HttpSession session, @RequestParam(name = "followUserId") Long followUserId){
        Long userId = (Long) session.getAttribute("userId");
        followService.addFollowUser(userId,followUserId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @DeleteMapping("/deleteFollow")
    public ResponseEntity<?> deleteFollow(HttpSession session, @RequestParam(name = "followUserId") Long followUserId){
        Long userId = (Long) session.getAttribute("userId");
        followService.deleteFollowUser(userId,followUserId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
