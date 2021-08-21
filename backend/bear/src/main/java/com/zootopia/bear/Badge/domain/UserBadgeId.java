package com.zootopia.bear.Badge.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserBadgeId implements Serializable {

	@Column(name = "badge_id")
	private int badgeId;
	@Column(name = "user_id")
	private long userId;
}