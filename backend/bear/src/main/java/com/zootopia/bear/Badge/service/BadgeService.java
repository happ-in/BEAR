package com.zootopia.bear.Badge.service;

import com.zootopia.bear.Badge.domain.Badge;
import com.zootopia.bear.Badge.repository.BadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BadgeService {
    private final BadgeRepository badgeRepository;

    @Autowired
    public BadgeService(BadgeRepository badgeRepository){
        this.badgeRepository = badgeRepository;
    }

    public List<Badge> getBadgeList(){
        return badgeRepository.findAll();
    }

    public Optional<Badge> getBadge(Integer badge_id){
        return badgeRepository.findById(badge_id);
    }
}
