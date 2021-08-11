package com.zootopia.bear.Badge.repository;

import com.zootopia.bear.Badge.domain.UserBadge;
import com.zootopia.bear.Badge.domain.UserBadgeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BadgeRepository extends JpaRepository<UserBadge, UserBadgeId> {
}
