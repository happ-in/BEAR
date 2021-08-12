package com.zootopia.bear.Follower.service;

import com.zootopia.bear.Follower.domain.Follower;
import com.zootopia.bear.Follower.domain.FollowerId;
import com.zootopia.bear.Follower.repository.FollowRepository;
import com.zootopia.bear.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowService {
    private final FollowRepository followRepository;
    private final UserRepository userRepository;

    @Autowired
    public FollowService(FollowRepository followRepository, UserRepository userRepository){
        this.followRepository = followRepository;
        this.userRepository = userRepository;
    }

    public void addFollowUser(Long userId,Long followUserId){
        FollowerId followerId = new FollowerId(userId,followUserId);
        followRepository.save(new Follower(followerId));
    }

    public void deleteFollowUser(Long userId,Long followUserId){
        followRepository.deleteById(new FollowerId(userId,followUserId));
    }
}