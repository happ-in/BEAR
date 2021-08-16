package com.zootopia.bear.Follow.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class FollowRegister {
	@NotNull(message = "로그인 되지 않은 사용자입니다.")
	private long userId;

	private long followerId;
}
