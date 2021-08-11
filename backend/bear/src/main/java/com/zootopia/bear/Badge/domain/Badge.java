package com.zootopia.bear.Badge.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Badge {
    @Id
    private int badgeId;
    private String title;
    private String explain;
    private String condition;
    private String badgeImage;
}
