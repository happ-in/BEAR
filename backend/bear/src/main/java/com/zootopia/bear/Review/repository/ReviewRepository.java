package com.zootopia.bear.Review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zootopia.bear.Review.domain.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
	List<Review> findAllByUserId(long userId);
}