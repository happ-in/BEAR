package com.zootopia.bear.Review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zootopia.bear.Review.domain.ReviewLike;
import com.zootopia.bear.Review.domain.ReviewLikeId;

@Repository
public interface UserReviewRepository extends JpaRepository<ReviewLike, ReviewLikeId> {
}
