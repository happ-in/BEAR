package com.zootopia.bear.Review.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

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
@Table(
	name = "review",
	uniqueConstraints = @UniqueConstraint(columnNames = {"userId", "beerId"})
)
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reviewId;

	private long userId;

	private int beerId;

	private double rating;

	private LocalDateTime startDate;

	@OneToMany(mappedBy = "review", fetch = FetchType.LAZY)
	private List<ReviewHashTag> reviewHashTags = new ArrayList<>();

	@OneToMany(mappedBy = "review", fetch = FetchType.LAZY)
	private List<ReviewLike> reviewLikes = new ArrayList<>();

	public static Review createReview(ReviewRegistryDto reviewRegistryDto) {
		return Review.builder()
			.userId(reviewRegistryDto.getUserId())
			.beerId(reviewRegistryDto.getBeerId())
			.rating(reviewRegistryDto.getRating())
			.startDate(LocalDateTime.now())
			.build();
	}
}
