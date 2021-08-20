package com.zootopia.bear.Snack.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Getter;

@Entity
@Getter
public class SnackCategory {

	@EmbeddedId
	private SnackCategoryId id;
}
