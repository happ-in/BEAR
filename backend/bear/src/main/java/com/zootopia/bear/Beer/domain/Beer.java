package com.zootopia.bear.Beer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Beer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int beerId;

	private String beerName;

	private String countryName;

	private String beerCategory;

	private double alcoholProof;

	private String beerImage;
}
