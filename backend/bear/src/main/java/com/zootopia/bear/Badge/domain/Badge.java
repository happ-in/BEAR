package com.zootopia.bear.Badge.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
public class Badge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int badge_id;
    private String title;
    private String explain;
    private String condition;
    private String badge_image;
}
