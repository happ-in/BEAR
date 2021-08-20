package com.zootopia.bear.HashTag.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class HashTagDto extends HashTagNameDto {
	private int hashTagId;

	public HashTagDto(int hashTagId, String hashTagName) {
		super(hashTagName);
		this.hashTagId = hashTagId;
	}
}