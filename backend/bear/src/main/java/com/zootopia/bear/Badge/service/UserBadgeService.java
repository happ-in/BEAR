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
        int badgeId = 1;
        UserBadgeId checkUserBadgeId = new UserBadgeId(badgeId,userId);
        Optional<UserBadge> userBadgeId =  userBadgeRepository.findById(checkUserBadgeId);
        if(userBadgeId.isPresent()) {
            return;
        }
        User user = userRepository.getById(userId);
        if(user.getShareCount()>=3) {
            UserBadge userBadge = new UserBadge(
                    checkUserBadgeId,
                    badgeRepository.getById(badgeId),
                    user
            );
            userBadgeRepository.save(userBadge);
        }
    }

    public void addColumbusBadge(long userId,int beerId) {
        int badgeId = 2;
        UserBadgeId checkUserBadgeId = new UserBadgeId(badgeId,userId);
        Optional<UserBadge> userBadgeId =  userBadgeRepository.findById(checkUserBadgeId);
        if(userBadgeId.isPresent()) {
            return;
        }
        if(!reviewRepository.findTopByBeerId(beerId).isPresent()) {
            UserBadge userBadge = new UserBadge(
                    checkUserBadgeId,
                    badgeRepository.getById(badgeId),
                    userRepository.getById(userId)
            );
            userBadgeRepository.save(userBadge);
        }
    }

    public void addAngelBadge(long userId) {
        int badgeId = 3;
        UserBadgeId checkUserBadgeId = new UserBadgeId(badgeId,userId);
        Optional<UserBadge> userBadgeId =  userBadgeRepository.findById(checkUserBadgeId);
        if(userBadgeId.isPresent()) {
            return;
        }
        List<Review> reviewList = reviewRepository.findAllByUserId(userId);
        int count = 0;
        for(Review review : reviewList) {
            if(review.getRating()>=4.5) {
                count++;
            }
        }
        if(count>=3) {
            UserBadge userBadge = new UserBadge(
                    checkUserBadgeId,
                    badgeRepository.getById(badgeId),
                    userRepository.getById(userId)
            );
            userBadgeRepository.save(userBadge);
        }
    }

    public void addDevilBadge(long userId) {
        int badgeId = 4;
        UserBadgeId checkUserBadgeId = new UserBadgeId(badgeId,userId);
        Optional<UserBadge> userBadgeId =  userBadgeRepository.findById(checkUserBadgeId);
        if(userBadgeId.isPresent()) {
            return;
        }
        List<Review> reviewList = reviewRepository.findAllByUserId(userId);
        int count = 0;
        for(Review review : reviewList) {
            if(review.getRating()<=1) {
                count++;
            }
        }
        if(count>=2) {
            UserBadge userBadge = new UserBadge(
                    checkUserBadgeId,
                    badgeRepository.getById(badgeId),
                    userRepository.getById(userId)
            );
            userBadgeRepository.save(userBadge);
        }

    }
}
