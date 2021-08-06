package com.zootopia.bear.Beer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BeerDto {
	private int beerId;
	private String beerName;
	private String beerImage;
}
