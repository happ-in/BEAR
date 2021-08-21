package com.zootopia.bear.User.dto;

import com.zootopia.bear.User.domain.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class UserInfoDto {
    private long userId;
    private String customId;
    private String nickname;
    private String sex;
    private String userImage;
    private int shareCount;
    private int reviewCount;
    private int followCount;
    private int followerCount;
}
