package com.zootopia.bear.User.repository;

import java.util.List;

import com.zootopia.bear.User.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByCustomIdContains(String customId);
}