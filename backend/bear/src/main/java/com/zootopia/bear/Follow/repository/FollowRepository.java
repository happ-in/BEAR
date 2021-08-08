package com.zootopia.bear.Follow.repository;

import com.zootopia.bear.Follow.domain.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Table(name="follow")
public interface FollowRepository extends JpaRepository<Follow, Long> {
    @Query("SELECT follow_id FROM Follow where user_id=:user_id")
    public List<Long> findByUser_id(@Param("user_id") Long user_id);

    @Query("SELECT user_id FROM Follow where follow_id=:follow_id")
    public List<Long> findByFollow_id(@Param("follow_id") Long follow_id);

    @Query("SELECT follow_id FROM Follow where user_id=:user_id and follow_id=:follow_id")
    public Long findByUser_idAndFollower_id(@Param("user_id") Long user_id,@Param("follow_id") Long follow_id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Follow where user_id=:user_id and follow_id=:follow_id")
    public void deleteByFollow_idAndUser_id(@Param("user_id") Long user_id,@Param("follow_id") Long follow_id);



}