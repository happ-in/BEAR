package com.zootopia.bear.Follow.service;

import java.util.Map;

import com.zootopia.bear.Follow.domain.Follow;
import com.zootopia.bear.Follow.domain.FollowerId;
import com.zootopia.bear.Follow.repository.FollowRepository;
import com.zootopia.bear.User.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowService {
	private final FollowRepository followRepository;
	private final UserRepository userRepository;

	@Autowired
	public FollowService(FollowRepository followRepository, UserRepository userRepository) {
		this.followRepository = followRepository;
		this.userRepository = userRepository;
	}

	public void addFollowUser(long userId, long followUserId) {
		FollowerId followerId = new FollowerId(userId, followUserId);
		followRepository.save(new Follow(followerId));
	}

	public void deleteFollowUser(long userId, long followUserId) {
		followRepository.deleteById(new FollowerId(userId, followUserId));
	}

	public boolean isFollowing(long userId, long followId) {
		return followRepository.findById(new FollowerId(userId, followId)).isPresent();
	}
}