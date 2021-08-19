package com.zootopia.bear.Badge.repository;

import com.zootopia.bear.Badge.domain.Badge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BadgeRepository extends JpaRepository<Badge, Integer> {
    Badge findByBadgeId(int badgeId);
}
