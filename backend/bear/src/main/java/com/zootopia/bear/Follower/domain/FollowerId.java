package com.zootopia.bear.Follower.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
@NoArgsConstructor
public class FollowerId implements Serializable {

    @Column(name = "user_id")
    private Long userId;
    @Column(name = "follow_user_id")
    private Long followUserId;

    public FollowerId(Long userId,Long followUserId){
        this.userId = userId;
        this.followUserId = followUserId;
    }
}
