package com.zootopia.bear.Follow.repository;

import com.zootopia.bear.Follow.domain.Follow;
import com.zootopia.bear.Follow.domain.FollowerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.List;

@Repository
@Table(name = "follow")
public interface FollowRepository extends JpaRepository<Follow, FollowerId> {

    public List<Follow> findAllByFollowerId_UserId(long userId);

    public List<Follow> findAllByFollowerId_FollowUserId(long followUserId);

}