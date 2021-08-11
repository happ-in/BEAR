package com.zootopia.bear.Review.dto;

import com.sun.istack.NotNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
public class ReviewLikeDto {

	@NotNull
	private long userId;

	@NotNull
	private int reviewId;
}
