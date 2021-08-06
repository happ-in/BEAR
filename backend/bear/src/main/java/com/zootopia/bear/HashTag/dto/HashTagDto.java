package com.zootopia.bear.HashTag.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HashTagDto extends HashTagNameDto {
	private int hashTagId;

	public HashTagDto(int hashTagId, String hashTagName) {
		super(hashTagName);
		this.hashTagId = hashTagId;
	}
}