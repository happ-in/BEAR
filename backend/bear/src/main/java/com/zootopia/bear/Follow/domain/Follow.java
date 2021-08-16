package com.zootopia.bear.Follow.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Follow {
	@EmbeddedId
	private FollowerId followerId;

}
