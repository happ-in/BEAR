package com.zootopia.bear.HashTag.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.zootopia.bear.Review.domain.Review;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewHashTag {

	@EmbeddedId
	private ReviewHashTagId id;

	@MapsId("reviewId")
	@ManyToOne
	@JoinColumn(name = "review_id")
	private Review review;

	@MapsId("hashTagId")
	@ManyToOne
	@JoinColumn(name = "hash_tag_id")
	private HashTag hashTag;

	@Builder
	public ReviewHashTag(Review review, HashTag hashTag) {
		this.id = new ReviewHashTagId(review.getReviewId(), hashTag.getHashTagId());
		this.review = review;
		this.hashTag = hashTag;
	}
}
