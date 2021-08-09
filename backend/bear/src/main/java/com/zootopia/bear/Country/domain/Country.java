package com.zootopia.bear.Country.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zootopia.bear.Beer.domain.Beer;

import lombok.Getter;

@Entity
@Getter
public class Country {
	@Id
	private String CountryName;

	private String CountryImage;

	@OneToMany(mappedBy = "country", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Beer> beers;
}
