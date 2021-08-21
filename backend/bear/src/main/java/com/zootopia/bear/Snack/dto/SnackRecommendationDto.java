package com.zootopia.bear.Snack.dto;

import java.util.ArrayList;
import java.util.List;

import com.zootopia.bear.Snack.domain.SnackDetail;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class SnackRecommendationDto {
	private String snackCategory;
	private List<SnackDto> snacks = new ArrayList<>();

	public SnackRecommendationDto(List<SnackDetail> snackDetails) {
		snackCategory = snackDetails.get(0).getId().getSnackCategoryName();
		for (SnackDetail snackDetail : snackDetails) {
			snacks.add(new SnackDto(snackDetail.getId().getSnackDetailName(), snackDetail.getSnackImage()));
		}
	}
}
