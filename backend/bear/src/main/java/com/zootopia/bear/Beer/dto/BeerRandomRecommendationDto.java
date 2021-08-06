package com.zootopia.bear.Beer.dto;

import java.util.ArrayList;
import java.util.List;

import com.zootopia.bear.Beer.domain.Beer;
import com.zootopia.bear.HashTag.dto.HashTagNameDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BeerRandomRecommendationDto {
	private int beerId;
	private String beerName;
	private String countryName;
	private String category;
	private double alcoholProof;
	private String beerImage;
	private List<HashTagNameDto> hashTags = new ArrayList<>();

	public BeerRandomRecommendationDto(Beer beer, List<HashTagNameDto> hashTagNameDtos) {
		this.beerId = beer.getBeerId();
		this.beerName = beer.getBeerName();
		this.countryName = beer.getCountryName();
		this.category = beer.getCategory();
		this.alcoholProof = beer.getAlcoholProof();
		this.beerImage = beer.getBeerImage();
		this.hashTags.addAll(hashTagNameDtos);
	}
}
