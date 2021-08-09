package com.zootopia.bear.Follower.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Follower {
    @EmbeddedId
    private FollowerId followerId;

}
