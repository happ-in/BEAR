package com.zootopia.bear.Badge.domain;

import com.zootopia.bear.Beer.domain.Beer;

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
    private Beer beer;
}
