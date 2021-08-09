package com.zootopia.bear.Beer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zootopia.bear.Beer.domain.Beer;

public interface BeerRepository extends JpaRepository<Beer, Integer>, BeerRankingRepositoryCustom {
	@Override
	Optional<Beer> findById(Integer beerId);

	@Query(value = "select * from beer order by rand() limit 1", nativeQuery = true)
	Beer searchRandomBeer();

	List<Beer> findByBeerNameContains(String beerName);
}
