package com.zootopia.bear.Follower.repository;

import com.zootopia.bear.Follower.domain.Follower;
import com.zootopia.bear.Follower.domain.FollowerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.List;

@Repository
@Table(name="follow")
public interface FollowRepository extends JpaRepository<Follower, FollowerId> {

    public List<Follower> findFollowersByFollowerId_UserId(Long userId);

    public List<Follower> findFollowersByFollowerId_FollowUserId(Long followUserId);

}