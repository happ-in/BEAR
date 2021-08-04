package com.zootopia.bear.HashTag.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.zootopia.bear.Beer.domain.Beer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "beer_hash_tag")
public class BeerHashTag {

	@EmbeddedId
	private BeerHashTagId id;

	@MapsId("beerId")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "beer_id")
	private Beer beer;

	@MapsId("hashTagId")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hash_tag_id")
	private HashTag hashTag;

	private int hashTagCount;

	public BeerHashTag(Beer beer, HashTag hashTag) {
		this.id = new BeerHashTagId(beer.getBeerId(), hashTag.getHashTagId());
		this.beer = beer;
		this.hashTag = hashTag;
		this.hashTagCount = 0;
	}

	public void addCount() {
		this.hashTagCount += 1;
	}
}
