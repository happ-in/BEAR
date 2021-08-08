package com.zootopia.bear.Follow.service;

import com.zootopia.bear.Follow.domain.Follow;
import com.zootopia.bear.Follow.repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowService {
    private final FollowRepository followRepository;

    @Autowired
    public FollowService(FollowRepository followRepository){
        this.followRepository = followRepository;
    }
    public List<Long> getFollows(Long user_id){
        return followRepository.findByUser_id(user_id);
    };

    public List<Long> getFollowers(Long user_id){
        return followRepository.findByFollow_id(user_id);
    }

    public void addFollow(Long user_id,Long follower_id){
        followRepository.save(new Follow(user_id, follower_id));
    }

    public void deleteFollow(Long user_id,Long follower_id){
        followRepository.deleteByFollow_idAndUser_id(user_id, follower_id);
    }

}