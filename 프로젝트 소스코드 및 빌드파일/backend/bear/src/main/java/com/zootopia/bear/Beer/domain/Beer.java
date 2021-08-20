package com.zootopia.bear.Beer.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.zootopia.bear.Country.domain.Country;

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

	@ManyToOne
	@JoinColumn(name = "country_name")
	private Country country;

	private String beerCategory;

	private double alcoholProof;

	private String beerImage;

	private String searchId;
}
