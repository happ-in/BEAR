package com.zootopia.bear.Follow.repository;

import com.zootopia.bear.Follow.domain.Follow;
import com.zootopia.bear.Follow.domain.FollowerId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

import java.util.List;
import java.util.Optional;

@Repository
@Table(name = "follow")
public interface FollowRepository extends JpaRepository<Follow, FollowerId> {
	@Override
	Optional<Follow> findById(FollowerId followerId);

	List<Follow> findAllByFollowerId_UserId(long userId);

	List<Follow> findAllByFollowerId_FollowUserId(long followUserId);

}