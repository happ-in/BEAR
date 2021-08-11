package com.zootopia.bear.Follower.service;

import com.zootopia.bear.Follower.domain.Follower;
import com.zootopia.bear.Follower.domain.FollowerId;
import com.zootopia.bear.Follower.dto.FollowDto;
import com.zootopia.bear.Follower.repository.FollowerRepository;
import com.zootopia.bear.User.domain.User;
import com.zootopia.bear.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FollowerService {
    private final FollowerRepository followerRepository;
    private final UserRepository userRepository;

    @Autowired
    public FollowerService(FollowerRepository followerRepository,UserRepository userRepository){
        this.followerRepository = followerRepository;
        this.userRepository = userRepository;
    }

    public void addFollowUser(Long userId,Long followUserId){
        FollowerId followerId = new FollowerId(userId,followUserId);
        followerRepository.save(new Follower(followerId));
    }

    public void deleteFollowUser(Long userId,Long followUserId){
        followerRepository.deleteById(new FollowerId(userId,followUserId));
    }





}