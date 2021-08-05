package com.zootopia.bear.Review.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewLike {

	@EmbeddedId
	private ReviewLikeId userReviewId;

	@MapsId(value = "reviewId")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "review_id")
	private Review review;

	public ReviewLike(long userid, Review review) {
		this.userReviewId = new ReviewLikeId(userid, review.getReviewId());
		this.review = review;
	}
}
