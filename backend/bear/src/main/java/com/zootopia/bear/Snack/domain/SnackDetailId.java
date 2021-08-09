package com.zootopia.bear.Snack.domain;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SnackDetailId implements Serializable {

	private String snackCategoryName;
	private String snackDetailName;
}
