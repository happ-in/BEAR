package com.zootopia.bear.Review.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.zootopia.bear.HashTag.domain.ReviewHashTag;
import com.zootopia.bear.Review.dto.ReviewRegistryDto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reviewId;

	private long userId;

	private int beerId;

	private double rating;

	@OneToMany(mappedBy = "review")
	private List<ReviewHashTag> reviewHashTags = new ArrayList<>();

	public static Review createReview(ReviewRegistryDto reviewRegistryDto) {
		return Review.builder()
			.userId(reviewRegistryDto.getUserId())
			.beerId(reviewRegistryDto.getBeerId())
			.rating(reviewRegistryDto.getRating())
			.build();
	}
}
