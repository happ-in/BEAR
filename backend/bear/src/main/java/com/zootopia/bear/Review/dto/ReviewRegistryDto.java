package com.zootopia.bear.Review.dto;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

	@NotNull(message = "로그인 되지 않은 사용자입니다.")
	private long userId;

	@NotNull(message = "어떤 맥주인지 선택해주세요.")
	private int beerId;

	@NotNull(message = "평점을 입력해주세요.")
	@Min(value = 1, message = "평점은 최소 1점 입니다.")
	@Max(value = 5, message = "평점은 최대 5점 입니다.")
	private double rating;

	@Size(min = 1, message = "하나 이상의 해시태그를 작성해주세요.")
	private List<HashTagDto> hashTags;
}
