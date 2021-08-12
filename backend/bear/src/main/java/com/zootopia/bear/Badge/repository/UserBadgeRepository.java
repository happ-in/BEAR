package com.zootopia.bear.Badge.repository;

import com.zootopia.bear.Badge.domain.UserBadge;
import com.zootopia.bear.Badge.domain.UserBadgeId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserBadgeRepository extends JpaRepository<UserBadge, UserBadgeId> {
    public List<UserBadge> findAllByUserBadgeId_UserId(Long userId);
}
