package com.zootopia.bear.HashTag.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zootopia.bear.HashTag.domain.HashTag;

@Repository
public interface HashTagRepository extends JpaRepository<HashTag, Integer>, HashTagRepositoryCustom {
	Optional<HashTag> findById(Integer hashTagId);

	Optional<HashTag> findByHashTagName(String hashTagName);

	List<HashTag> findByHashTagNameContains(String hashTagName);
}
