package com.zootopia.bear.Snack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zootopia.bear.Snack.domain.SnackDetail;
import com.zootopia.bear.Snack.domain.SnackDetailId;

@Repository
public interface SnackDetailRepository extends JpaRepository<SnackDetail, SnackDetailId> {
	@Query(value = "select * from snack_detail where snack_category_name in"
		+ " (select * from "
		+ " (select snack_category_name from snack_category where beer_category=:beerCategory order by rand() limit 1) as randomCategory)"
		+ " order by rand() limit 3", nativeQuery = true)
	List<SnackDetail> searchRandomSnack(@Param("beerCategory") String beerCategory);
}
