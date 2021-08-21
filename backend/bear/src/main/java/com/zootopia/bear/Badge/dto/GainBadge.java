package com.zootopia.bear.Badge.dto;

import com.zootopia.bear.Badge.domain.Badge;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class GainBadge {
    private String title;
    private String explain;
    private String condition;
    private String badgeImage;
    private String acquisitionDate;
    private boolean isGain;

    public GainBadge(Badge badge,String acquisitionDate,boolean isGain) {
        this.title = badge.getTitle();
        this.explain = badge.getExplain();
        this.condition = badge.getCondition();
        this.badgeImage = badge.getBadgeImage();
        this.acquisitionDate = acquisitionDate;
        this.isGain = isGain;
    }

}
