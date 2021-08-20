package com.zootopia.bear.Rank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RankDto {
	private int beerId;
	private String beerName;
	private String countryName;
	private String beerCategory;
	private double alcoholProof;
	private String beerImage;
	private long totalCount;
}
