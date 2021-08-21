package com.zootopia.bear.Review.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
