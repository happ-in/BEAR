package com.zootopia.bear.Beer.dto;

import java.util.ArrayList;
import java.util.List;

import com.zootopia.bear.Beer.domain.Beer;
import com.zootopia.bear.Country.domain.Country;
import com.zootopia.bear.HashTag.dto.HashTagTotalDto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
public class BeerHashTagDto {
	private int beerId;
	private String beerName;
	private String beerCategory;
	private Country country;
	private double alcoholProof;
	private String beerImage;
	private double beerAvg;
	private List<HashTagTotalDto> hashTags = new ArrayList<>();

	public BeerHashTagDto(Beer beer, double beerAvg, List<HashTagTotalDto> hashTagTotalDtos) {
		this.beerId = beer.getBeerId();
		this.beerName = beer.getBeerName();
		this.country = beer.getCountry();
		this.beerCategory = beer.getBeerCategory();
		this.alcoholProof = beer.getAlcoholProof();
		this.beerImage = beer.getBeerImage();
		this.beerAvg = beerAvg;
		this.hashTags.addAll(hashTagTotalDtos);
	}
}
