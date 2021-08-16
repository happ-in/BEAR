package com.zootopia.bear.Follow.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class FollowerId implements Serializable {

	@Column(name = "user_id")
	private Long userId;
	@Column(name = "follow_user_id")
	private Long followUserId;

}
