package com.zootopia.bear.Snack.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zootopia.bear.Snack.domain.SnackDetail;
import com.zootopia.bear.Snack.dto.SnackRecommendationDto;
import com.zootopia.bear.Snack.repository.SnackDetailRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SnackRecommendationService {

	private final SnackDetailRepository snackDetailRepository;

	public SnackRecommendationDto SnackRecommendation(String beerCategory) {
		List<SnackDetail> snackDetails = snackDetailRepository.searchRandomSnack(beerCategory);
		return new SnackRecommendationDto(snackDetails);
	}
}
