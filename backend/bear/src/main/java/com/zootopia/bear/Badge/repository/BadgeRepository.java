package com.zootopia.bear.Badge.repository;


import com.zootopia.bear.Badge.domain.Badge;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BadgeRepository extends JpaRepository<Badge, Integer> {

}
