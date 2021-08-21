package com.zootopia.bear.HashTag.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewHashTagId implements Serializable {

	@Column(name = "review_id")
	private int reviewId;

	@Column(name = "hash_tag_id")
	private int hashTagId;
}
