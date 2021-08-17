package com.zootopia.bear.Beer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zootopia.bear.Beer.domain.Beer;

public interface BeerRepository extends JpaRepository<Beer, Integer>, BeerRepositoryCustom {
	Beer findById(int id);

	@Query(value = "select * from beer order by rand() limit 1", nativeQuery = true)
	Beer searchRandomBeer();

	List<Beer> findByBeerNameContains(String beerName);

	Beer findBySearchId(String searchId);

	@Query(value = "select * from beer where beer_id in (select distinct beer_id from review_hash_tag where hash_tag_id = :hashTagId)", nativeQuery = true)
	List<Beer> findByHashTag(@Param("hashTagId") int hashTagId);
}
