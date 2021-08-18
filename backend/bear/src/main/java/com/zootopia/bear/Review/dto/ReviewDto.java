package com.zootopia.bear.Review.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.zootopia.bear.Beer.domain.Beer;
import com.zootopia.bear.HashTag.domain.HashTag;
import com.zootopia.bear.User.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ReviewDto {
	private int reviewId;
	private UserDto user;
	private double rating;
	private Beer beer;
	private long totalLike;
	private boolean isLike;
	private LocalDateTime startDate;
	private List<HashTag> hashTags;
}
