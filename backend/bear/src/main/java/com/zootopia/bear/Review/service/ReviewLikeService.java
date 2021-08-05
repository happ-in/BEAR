package com.zootopia.bear.Review.service;

import org.springframework.stereotype.Service;

import com.zootopia.bear.Review.domain.Review;
import com.zootopia.bear.Review.domain.ReviewLike;
import com.zootopia.bear.Review.dto.ReviewLikeDto;
import com.zootopia.bear.Review.domain.ReviewLikeId;
import com.zootopia.bear.Review.repository.ReviewRepository;
import com.zootopia.bear.Review.repository.UserReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewLikeService {

	private final UserReviewRepository userReviewRepository;
	private final ReviewRepository reviewRepository;

	public void reviewLike(ReviewLikeDto reviewLikeDto) {
		Review review =
			reviewRepository.findById(reviewLikeDto.getReviewId())
				.orElseThrow(NullPointerException::new);
		userReviewRepository.save(new ReviewLike(reviewLikeDto.getUserId(), review));
	}

	public void reviewDislike(ReviewLikeDto reviewLikeDto) {
		userReviewRepository
			.deleteById(new ReviewLikeId(reviewLikeDto.getUserId(), reviewLikeDto.getReviewId()));
	}

}
