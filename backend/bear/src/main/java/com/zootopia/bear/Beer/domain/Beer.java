package com.zootopia.bear.Beer.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.zootopia.bear.HashTag.domain.BeerHashTag;

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

	private String country_name;

	private String category;

	private double alcoholProof;

	private String beer_image;

	@OneToMany(mappedBy = "beer")
	private List<BeerHashTag> beerHashTags = new ArrayList<>();
}
