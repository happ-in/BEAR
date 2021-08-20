package com.zootopia.bear.Badge.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Badge {
    @Id
    private int badgeId;
    private String title;

    @Column(name = "badge_explain")
    private String explain;

    @Column(name = "badge_condition")
    private String condition;

    @Column(name = "badge_Image")
    private String badgeImage;
}
