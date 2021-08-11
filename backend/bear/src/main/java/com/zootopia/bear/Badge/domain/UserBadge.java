package com.zootopia.bear.Badge.domain;

import com.zootopia.bear.Beer.domain.Beer;
import com.zootopia.bear.User.domain.User;

import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

public class UserBadge {
    @EmbeddedId
    private UserBadgeId userBadgeId;

    @MapsId("badgeId")
    @ManyToOne
    @JoinColumn(name = "badge_id")
    private Badge badge;

    @MapsId("beerId")
    @ManyToOne
    @JoinColumn(name = "beer_id")
    private Beer beer;
}
