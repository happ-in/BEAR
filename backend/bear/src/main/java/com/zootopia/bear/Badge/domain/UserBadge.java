package com.zootopia.bear.Badge.domain;

import com.zootopia.bear.User.domain.User;

import javax.persistence.*;

@Entity
public class UserBadge {
    @EmbeddedId
    private UserBadgeId userBadgeId;

    @MapsId("badgeId")
    @ManyToOne
    @JoinColumn(name = "badge_id")
    private Badge badge;

    @MapsId("userId")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
