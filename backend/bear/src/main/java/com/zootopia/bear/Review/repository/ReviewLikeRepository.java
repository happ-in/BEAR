package com.zootopia.bear.Review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zootopia.bear.Review.domain.ReviewLike;
import com.zootopia.bear.Review.domain.ReviewLikeId;

@Repository
public interface ReviewLikeRepository extends JpaRepository<ReviewLike, ReviewLikeId> {
	@Query(value = "select count(*) from review_like where review_id=:reviewId", nativeQuery = true)
	long searchAllByReviewId(@Param("reviewId") int reviewId);
}
