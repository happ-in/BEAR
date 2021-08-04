package com.zootopia.bear.HashTag.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zootopia.bear.HashTag.domain.HashTag;

@Repository
public interface HashTagRepository extends JpaRepository<HashTag, Integer> {
	Optional<HashTag> findById(Integer integer);

	Optional<HashTag> findByHashTagName(String hashTagName);
}
