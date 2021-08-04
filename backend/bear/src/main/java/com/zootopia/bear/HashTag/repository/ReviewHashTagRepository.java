package com.zootopia.bear.HashTag.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zootopia.bear.HashTag.domain.ReviewHashTag;
import com.zootopia.bear.HashTag.domain.ReviewHashTagId;

@Repository
public interface ReviewHashTagRepository extends JpaRepository<ReviewHashTag, ReviewHashTagId> {
}
