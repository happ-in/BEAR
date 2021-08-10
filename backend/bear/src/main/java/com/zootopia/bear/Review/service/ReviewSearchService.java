package com.zootopia.bear.Review.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zootopia.bear.Beer.domain.Beer;
import com.zootopia.bear.Beer.repository.BeerRepository;
import com.zootopia.bear.HashTag.domain.HashTag;
import com.zootopia.bear.HashTag.domain.ReviewHashTag;
import com.zootopia.bear.HashTag.repository.HashTagRepository;
import com.zootopia.bear.HashTag.repository.ReviewHashTagRepository;
import com.zootopia.bear.Review.domain.Review;
import com.zootopia.bear.Review.domain.ReviewLikeId;
import com.zootopia.bear.Review.dto.ReviewDto;
import com.zootopia.bear.Review.repository.ReviewLikeRepository;
import com.zootopia.bear.Review.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewSearchService {

	private final BeerRepository beerRepository;
	private final ReviewRepository reviewRepository;
	private final ReviewHashTagRepository reviewHashTagRepository;
	private final HashTagRepository hashTagRepository;
	private final ReviewLikeRepository reviewLikeRepository;

	public List<ReviewDto> searchMyReview(long userId) {
		List<ReviewDto> reviewDtos = new ArrayList<>();

		// 1. 내가 작성한 리뷰 가져오기
		List<Review> reviews = reviewRepository.findAllByUserId(userId);
		for (Review review : reviews) {
			// 2. 맥주 정보 가져오기
			Beer beer = getBeer(review);
			List<HashTag> hashTags = getHashTags(review);
			int reviewId = review.getReviewId();
			boolean isLike = isLike(userId, reviewId);
			long totalLike = getTotalLike(reviewId);
			ReviewDto reviewDto = ReviewDto.builder()
				.beer(beer)
				.reviewId(review.getReviewId())
				.rating(review.getRating())
				.hashTags(hashTags)
				.isLike(isLike)
				.totalLike(totalLike)
				.build();
			reviewDtos.add(reviewDto);
		}
		return reviewDtos;
	}

	private long getTotalLike(int reviewId) {
		long totalLike = reviewLikeRepository.searchAllByReviewId(reviewId).size();
		return totalLike;
	}

	private boolean isLike(long userId, int reviewId) {
		boolean isLike = reviewLikeRepository.findById(new ReviewLikeId(userId, reviewId)).isPresent();
		return isLike;
	}

	private List<HashTag> getHashTags(Review review) {
		List<ReviewHashTag> reviewHashTags = reviewHashTagRepository.findAllByReview(review);
		List<HashTag> hashTags = new ArrayList<>();
		for (ReviewHashTag reviewHashTag : reviewHashTags) {
			HashTag hashTag = hashTagRepository.findById(reviewHashTag.getHashTag().getHashTagId()).get();
			hashTags.add(hashTag);
		}
		return hashTags;
	}

	private Beer getBeer(Review review) {
		return beerRepository.findById(review.getBeerId());
	}
}
