package com.zootopia.bear.Review.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zootopia.bear.HashTag.domain.HashTag;
import com.zootopia.bear.HashTag.domain.ReviewHashTag;
import com.zootopia.bear.HashTag.dto.HashTagDto;
import com.zootopia.bear.HashTag.dto.HashTagNameDto;
import com.zootopia.bear.HashTag.repository.HashTagRepository;
import com.zootopia.bear.HashTag.repository.ReviewHashTagRepository;
import com.zootopia.bear.Review.domain.Review;
import com.zootopia.bear.Review.dto.ReviewRegistryDto;
import com.zootopia.bear.Review.dto.ReviewUpdateDto;
import com.zootopia.bear.Review.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewRegistryService {

	private final HashTagRepository hashTagRepository;
	private final ReviewRepository reviewRepository;
	private final ReviewHashTagRepository reviewHashTagRepository;

	public void reviewRegistry(ReviewRegistryDto reviewRegistryDto) {
		Review review = reviewRepository.save(Review.createReview(reviewRegistryDto));
		saveHashTag(reviewRegistryDto.getHashTags(), review);
	}

	public void reviewUpdate(ReviewUpdateDto reviewUpdateDto) {
		int reviewId = reviewUpdateDto.getReviewId();
		reviewRepository.updateReview(reviewId, reviewUpdateDto.getRating());
		Review review = reviewRepository.findById(reviewId).orElseThrow(NullPointerException::new);
		reviewHashTagRepository.deleteByReviewId(reviewId);
		saveHashTag(reviewUpdateDto.getHashTags(), review);
	}

	private void saveHashTag(List<HashTagDto> hashTagNameDtos, Review review) {
		for (HashTagNameDto hashTagNameDto : hashTagNameDtos) {
			// 1. 해시태그 등록
			HashTag hashTag =
				hashTagRepository.findByHashTagName(hashTagNameDto.getHashTagName())
					.orElseGet(() -> hashTagRepository.save(new HashTag(hashTagNameDto.getHashTagName())));

			// 2. 리뷰-해시태그 등록
			reviewHashTagRepository.save(new ReviewHashTag(review, hashTag));
		}
	}
}
