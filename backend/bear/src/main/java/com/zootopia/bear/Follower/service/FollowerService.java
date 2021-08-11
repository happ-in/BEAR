package com.zootopia.bear.Follower.service;

import com.zootopia.bear.Follower.domain.Follower;
import com.zootopia.bear.Follower.domain.FollowerId;
import com.zootopia.bear.Follower.repository.FollowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FollowerService {
    private final FollowerRepository followerRepository;

    @Autowired
    public FollowerService(FollowerRepository followerRepository){
        this.followerRepository = followerRepository;
    }

    public void addFollowUser(Long userId,Long followUserId){
        FollowerId followerId = new FollowerId(userId,followUserId);
        followerRepository.save(new Follower(followerId));
    }

    public void deleteFollowUser(Long userId,Long followUserId){
        followerRepository.deleteById(new FollowerId(userId,followUserId));
    }

    public List<Long> getFollowList(Long userId){
        List<Follower> list = followerRepository.findFollowersByFollowerId_UserId(userId);
        List<Long> followList = new ArrayList<>();
        for(Follower follower : list) {
            followList.add(follower.getFollowerId().getFollowUserId());
        }
        return followList;
    }

    public List<Long> getFollowerList(Long followUserId){
        List<Follower> list = followerRepository.findFollowersByFollowerId_FollowUserId(followUserId);
        List<Long> followerList = new ArrayList<>();
        for(Follower follower : list) {
            followerList.add(follower.getFollowerId().getFollowUserId());
        }
        return followerList;
    }

}