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
		// 1. 내가 작성한 리뷰 가져오기
		List<Review> reviews = reviewRepository.findAllByUserId(userId);
		return getReviewDtos(userId, reviews);
	}

	public List<ReviewDto> feed(long userId) {
		List<Review> reviews = reviewRepository.searchFeed(userId);
		return getReviewDtos(userId, reviews);
	}

	private List<ReviewDto> getReviewDtos(long userId, List<Review> reviews) {
		List<ReviewDto> reviewDtos = new ArrayList<>();
		for (Review review : reviews) {
			// 2. 맥주 정보 가져오기
			Beer beer = beerRepository.findById(review.getBeerId());
			List<HashTag> hashTags = getHashTags(review);
			int reviewId = review.getReviewId();
			boolean isLike = reviewLikeRepository.findById(new ReviewLikeId(userId, reviewId)).isPresent();
			long totalLike = reviewLikeRepository.searchAllByReviewId(reviewId);
			ReviewDto reviewDto = ReviewDto.builder()
				.beer(beer)
				.reviewId(review.getReviewId())
				.rating(review.getRating())
				.hashTags(hashTags)
				.isLike(isLike)
				.totalLike(totalLike)
				.startDate(review.getStartDate())
				.build();
			reviewDtos.add(reviewDto);
		}
		return reviewDtos;
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
}
