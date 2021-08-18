package com.zootopia.bear.Badge.domain;

import com.zootopia.bear.User.domain.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserBadge {
    @EmbeddedId
    private UserBadgeId userBadgeId;
    private LocalDateTime acquisitionDate;

    @MapsId("badgeId")
    @ManyToOne
    @JoinColumn(name = "badge_id")
    private Badge badge;

    @MapsId("userId")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

