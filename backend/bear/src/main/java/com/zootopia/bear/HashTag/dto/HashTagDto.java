package com.zootopia.bear.HashTag.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HashTagDto {
	private int hashTagId;
	private String hashTagName;

	public HashTagDto() {}

	public HashTagDto(String hashTagName) {
		this.hashTagName = hashTagName;
	}
}
