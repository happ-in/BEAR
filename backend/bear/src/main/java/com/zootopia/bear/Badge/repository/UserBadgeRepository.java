package com.zootopia.bear.Badge.repository;

import com.zootopia.bear.Badge.domain.UserBadge;
import com.zootopia.bear.Badge.domain.UserBadgeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.List;

@Repository
@Table(name = "user_badge")
public interface UserBadgeRepository extends JpaRepository<UserBadge, UserBadgeId> {
    List<UserBadge> findAllByUserBadgeId_UserId(long userId);
    UserBadge findByUserBadgeId(UserBadgeId userBadgeId);
}
