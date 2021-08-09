package com.zootopia.bear.Beer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zootopia.bear.Beer.domain.Beer;

<<<<<<< HEAD
public interface BeerRepository extends JpaRepository<Beer, Integer>, BeerRepositoryCustom {
	@Override
	Optional<Beer> findById(Integer beerId);
=======
public interface BeerRepository extends JpaRepository<Beer, Integer> {
	Beer findById(int id);
>>>>>>> d5842e9edf429c209615a7c451f3d90c9dfc674b

	@Query(value = "select * from beer order by rand() limit 1", nativeQuery = true)
	Beer searchRandomBeer();

	List<Beer> findByBeerNameContains(String beerName);
}
