package com.zootopia.bear.Review.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zootopia.bear.HashTag.domain.ReviewHashTag;
import com.zootopia.bear.HashTag.repository.ReviewHashTagRepository;
import com.zootopia.bear.Review.domain.Review;
import com.zootopia.bear.Review.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewDeletionService {

	private final ReviewRepository reviewRepository;


	@Transactional
	public void reviewDeletion(int reviewId) {
		reviewRepository.deleteById(reviewId);
	}
}
