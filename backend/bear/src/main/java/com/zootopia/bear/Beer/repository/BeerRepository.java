package com.zootopia.bear.Beer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zootopia.bear.Beer.domain.Beer;

public interface BeerRepository extends JpaRepository<Beer, Integer> {
	@Override
	Optional<Beer> findById(Integer id);
}
