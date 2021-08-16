package com.zootopia.bear.Follow.controller;



import com.zootopia.bear.Follow.dto.FollowRegister;
import com.zootopia.bear.Follow.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/follower")
@RestController
public class FollowController {
    private final FollowService followService;

    @Autowired
    public FollowController(FollowService followService) {
        this.followService = followService;
    }

    @PostMapping("/addFollow")
    public ResponseEntity<?> addFollow(@RequestBody FollowRegister followRegister){
        long userId = followRegister.getUserId();
        long followUserId = followRegister.getFollowerId();
        followService.addFollowUser(userId,followUserId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @DeleteMapping("/deleteFollow")
    public ResponseEntity<?> deleteFollow(@RequestBody FollowRegister followRegister){
        long userId = followRegister.getUserId();
        long followUserId = followRegister.getFollowerId();
        followService.deleteFollowUser(userId,followUserId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
