package com.zootopia.bear.User.dto;

import lombok.Getter;

@Getter
public class UserUpdateDto {
    private long userId;
    private String customId;
    private String nickname;
}
