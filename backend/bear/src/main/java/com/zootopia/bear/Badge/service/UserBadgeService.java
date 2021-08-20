package com.zootopia.bear.Badge.service;

import com.zootopia.bear.Badge.domain.UserBadge;
import com.zootopia.bear.Badge.domain.UserBadgeId;
import com.zootopia.bear.Badge.repository.BadgeRepository;
import com.zootopia.bear.Badge.repository.UserBadgeRepository;
import com.zootopia.bear.Review.domain.Review;
import com.zootopia.bear.Review.repository.ReviewRepository;
import com.zootopia.bear.User.domain.User;
import com.zootopia.bear.User.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserBadgeService {

	private final UserBadgeRepository userBadgeRepository;
	private final UserRepository userRepository;
	private final BadgeRepository badgeRepository;
	private final ReviewRepository reviewRepository;

	public void addExpertBadge(long userId) {
		int badgeId = 4;
		UserBadgeId checkUserBadgeId = new UserBadgeId(badgeId, userId);
		Optional<UserBadge> userBadgeId = userBadgeRepository.findById(checkUserBadgeId);
		if (userBadgeId.isPresent()) {
			return;
		}
		User user = userRepository.findById(userId).get();
		if (user.getShareCount() >= 3) {
			UserBadge userBadge = new UserBadge(
				checkUserBadgeId,
				LocalDateTime.now(),
				badgeRepository.getById(badgeId),
				user
			);
			userBadgeRepository.save(userBadge);
		}
	}

	public void addColumbusBadge(long userId, int beerId) {
		int badgeId = 5;
		UserBadgeId checkUserBadgeId = new UserBadgeId(badgeId, userId);
		Optional<UserBadge> userBadgeId = userBadgeRepository.findById(checkUserBadgeId);
		if (userBadgeId.isPresent()) {
			return;
		}
		if (!(reviewRepository.findByBeerId(beerId).isPresent())) {
			UserBadge userBadge = new UserBadge(
				checkUserBadgeId,
				LocalDateTime.now(),
				badgeRepository.findByBadgeId(badgeId),
				userRepository.findByUserId(userId)
			);
			userBadgeRepository.save(userBadge);
		}
	}

	public void addAngelBadge(long userId) {
		int badgeId = 6;
		UserBadgeId checkUserBadgeId = new UserBadgeId(badgeId, userId);
		Optional<UserBadge> userBadgeId = userBadgeRepository.findById(checkUserBadgeId);
		if (userBadgeId.isPresent()) {
			return;
		}
		List<Review> reviewList = reviewRepository.findAllByUserId(userId);
		int count = 0;
		for (Review review : reviewList) {
			if (review.getRating() >= 4.5) {
				count++;
			}
		}
		if (count >= 3) {
			UserBadge userBadge = new UserBadge(
				checkUserBadgeId,
				LocalDateTime.now(),
				badgeRepository.getById(badgeId),
				userRepository.getById(userId)
			);
			userBadgeRepository.save(userBadge);
		}
	}

	public void addDevilBadge(long userId) {
		int badgeId = 7;
		UserBadgeId checkUserBadgeId = new UserBadgeId(badgeId, userId);
		Optional<UserBadge> userBadgeId = userBadgeRepository.findById(checkUserBadgeId);
		if (userBadgeId.isPresent()) {
			return;
		}
		List<Review> reviewList = reviewRepository.findAllByUserIdOrderByStartDateDesc(userId);
		int count = 0;
		for (Review review : reviewList) {
			if (review.getRating() <= 1) {
				count++;
			}
		}
		if (count >= 2) {
			UserBadge userBadge = new UserBadge(
				checkUserBadgeId,
				LocalDateTime.now(),
				badgeRepository.getById(badgeId),
				userRepository.getById(userId)
			);
			userBadgeRepository.save(userBadge);
		}
	}
}
