package com.zootopia.bear.HashTag.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.zootopia.bear.Beer.domain.Beer;
import com.zootopia.bear.HashTag.dto.HashTagDto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HashTag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hashTagId;

	private String  hashTagName;

	@OneToOne(mappedBy = "hashTag")
	private ReviewHashTag reviewHashTag;

	@OneToOne(mappedBy = "hashTag")
	private BeerHashTag beerHashTag;

	public HashTag(String hashTagName) {
		this.hashTagName = hashTagName;
	}

	public HashTag(int hashTagId, String hashTagName) {
		this.hashTagId = hashTagId;
		this.hashTagName = hashTagName;
	}
}
