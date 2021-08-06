package com.zootopia.bear.HashTag.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HashTagTotalDto {
	private int hashTagId;
	private String hashTagName;
	private long total;
}
