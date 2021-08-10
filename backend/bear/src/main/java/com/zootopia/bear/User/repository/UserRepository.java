package com.zootopia.bear.User.repository;

import com.zootopia.bear.Beer.domain.Beer;
import com.zootopia.bear.User.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}