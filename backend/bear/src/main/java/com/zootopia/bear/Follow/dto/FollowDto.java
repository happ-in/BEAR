package com.zootopia.bear.Follow.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FollowDto {
    private Long userId;
    private String nickname;
    private String userImage;
}