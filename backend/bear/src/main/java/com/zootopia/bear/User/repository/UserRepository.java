package com.zootopia.bear.User.repository;

import com.zootopia.bear.User.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    //nickname 중복여부 확인 1. 리스트로 전부 다 찾기 2. 자기 자신 제외하고 찾기
//    @Query("SELECT nickname FROM User where userId=:userId")
//    public String findNicknameByUserId(@Param("userId") Long userId);
}