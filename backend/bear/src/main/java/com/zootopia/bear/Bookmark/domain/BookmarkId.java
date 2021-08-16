package com.zootopia.bear.Bookmark.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class BookmarkId implements Serializable {

	@Column(name = "user_id")
	@NotNull(message = "로그인 되지 않은 사용자입니다.")
	private long userId;

	@Column(name = "beer_id")
	private int beerId;
}
