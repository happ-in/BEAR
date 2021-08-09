package com.zootopia.bear.Review.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zootopia.bear.Review.domain.Review;
import com.zootopia.bear.Review.domain.ReviewLike;
import com.zootopia.bear.Review.dto.ReviewLikeDto;
import com.zootopia.bear.Review.domain.ReviewLikeId;
import com.zootopia.bear.Review.repository.ReviewRepository;
import com.zootopia.bear.Review.repository.ReviewLikeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewLikeService {

	private final ReviewLikeRepository reviewLikeRepository;
	private final ReviewRepository reviewRepository;

	public void reviewLike(ReviewLikeDto reviewLikeDto) {
		Review review =
			reviewRepository.findById(reviewLikeDto.getReviewId())
				.orElseThrow(NullPointerException::new);
		reviewLikeRepository.save(new ReviewLike(reviewLikeDto.getUserId(), review));
	}

	public void reviewDislike(ReviewLikeDto reviewLikeDto) {
		reviewLikeRepository
			.deleteById(new ReviewLikeId(reviewLikeDto.getUserId(), reviewLikeDto.getReviewId()));
	}

}
