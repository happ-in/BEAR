package com.zootopia.bear.Badge.domain;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserBadgeId implements Serializable {

    @Column(name = "badge_id")
    private int badgeId;
    @Column(name = "user_id")
    private Long userId;

}