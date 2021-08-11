package com.zootopia.bear.Badge.repository;

import com.zootopia.bear.Badge.domain.UserBadge;
import com.zootopia.bear.Badge.domain.UserBadgeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBadgeRepository extends JpaRepository<UserBadge, UserBadgeId> {
}
