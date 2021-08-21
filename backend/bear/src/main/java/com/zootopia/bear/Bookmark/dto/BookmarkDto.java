package com.zootopia.bear.Bookmark.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
public class BookmarkDto {
    @NotNull(message = "로그인 되지 않은 사용자입니다.")
    private long userId;
    @NotNull
    private int beerId;
}
