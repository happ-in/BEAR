package com.zootopia.bear.HashTag.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
public class HashTagNameDto {

	@NotBlank(message = "해시태그는 빈 칸일 수 없습니다.")
	private String hashTagName;
}
