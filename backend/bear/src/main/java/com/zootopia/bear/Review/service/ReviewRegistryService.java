package com.zootopia.bear.Review.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zootopia.bear.HashTag.domain.HashTag;
import com.zootopia.bear.HashTag.domain.ReviewHashTag;
import com.zootopia.bear.HashTag.dto.HashTagDto;
import com.zootopia.bear.HashTag.repository.HashTagRepository;
import com.zootopia.bear.HashTag.repository.ReviewHashTagRepository;
import com.zootopia.bear.Review.domain.Review;
import com.zootopia.bear.Review.dto.ReviewRegistryDto;
import com.zootopia.bear.Review.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewRegistryService {

	private final HashTagRepository hashTagRepository;
	private final ReviewRepository reviewRepository;
	private final ReviewHashTagRepository reviewHashTagRepository;

	@Transactional
	public void registryReview(ReviewRegistryDto reviewRegistryDto) {
		// 1. 리뷰 등록
		Review review = reviewRepository.save(Review.createReview(reviewRegistryDto));

		for (HashTagDto hashTagDto : reviewRegistryDto.getHashTags()) {
			// 1. 해시태그 등록
			HashTag hashTag =
				hashTagRepository.findByHashTagName(hashTagDto.getHashTagName())
					.orElseGet(() -> hashTagRepository.save(new HashTag(hashTagDto.getHashTagName())));

			// 2. 리뷰-해시태그 등록
			reviewHashTagRepository.save(new ReviewHashTag(review, hashTag));
		}
	}
}
