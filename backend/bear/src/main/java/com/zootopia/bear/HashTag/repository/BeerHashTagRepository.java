package com.zootopia.bear.HashTag.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zootopia.bear.HashTag.domain.BeerHashTag;
import com.zootopia.bear.HashTag.domain.BeerHashTagId;

@Repository
public interface BeerHashTagRepository extends JpaRepository<BeerHashTag, BeerHashTagId> {
	@Override
	List<BeerHashTag> findAll();

	Optional<BeerHashTag> findById(BeerHashTagId id);
}
