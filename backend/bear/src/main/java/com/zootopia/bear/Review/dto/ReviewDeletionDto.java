package com.zootopia.bear.Review.dto;

import java.util.List;

import com.zootopia.bear.HashTag.dto.HashTagNameDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewDeletionDto {
	private int reviewId;
	private int beerId;
	private double rating;
	private List<HashTagNameDto> hashTags;
}
