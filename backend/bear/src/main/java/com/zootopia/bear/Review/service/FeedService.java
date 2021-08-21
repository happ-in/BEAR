package com.zootopia.bear.Review.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zootopia.bear.Beer.domain.Beer;
import com.zootopia.bear.HashTag.domain.HashTag;
import com.zootopia.bear.Review.domain.Review;
import com.zootopia.bear.Review.dto.ReviewDto;
import com.zootopia.bear.Review.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FeedService {

	private ReviewRepository reviewRepository;
}
