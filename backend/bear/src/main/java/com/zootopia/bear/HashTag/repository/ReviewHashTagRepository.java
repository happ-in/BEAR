package com.zootopia.bear.HashTag.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zootopia.bear.HashTag.domain.ReviewHashTag;
import com.zootopia.bear.HashTag.domain.ReviewHashTagId;
import com.zootopia.bear.Review.domain.Review;

@Repository
public interface ReviewHashTagRepository extends JpaRepository<ReviewHashTag, ReviewHashTagId> {

	List<ReviewHashTag> findAllByReview(Review review);
}
