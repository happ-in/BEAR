package com.zootopia.bear.Snack.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SnackCategoryId implements Serializable {
	private String snackCategoryName;
	private String beerCategory;
}
