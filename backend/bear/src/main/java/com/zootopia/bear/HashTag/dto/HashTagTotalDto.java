package com.zootopia.bear.HashTag.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
public class HashTagTotalDto {
	private int hashTagId;
	private String hashTagName;
	private long total;
}
