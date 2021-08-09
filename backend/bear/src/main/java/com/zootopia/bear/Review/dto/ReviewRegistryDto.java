package com.zootopia.bear.Review.dto;

import java.util.List;

import com.zootopia.bear.HashTag.dto.HashTagDto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
public class ReviewRegistryDto {
	private long userId;
	private int beerId;
	private double rating;
	private List<HashTagDto> hashTags;
}
