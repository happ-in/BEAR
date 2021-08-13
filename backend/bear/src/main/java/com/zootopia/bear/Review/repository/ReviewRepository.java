package com.zootopia.bear.Review.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zootopia.bear.Review.domain.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
	List<Review> findAllByUserId(long userId);

	@Query(value = "select sum(rating)/count(*) from review where beer_id=1 group by beer_id;", nativeQuery = true)
	double beerAvg(int beerId);

	@Modifying(clearAutomatically = true)
	@Query(value = "update review set rating = :rating where review_id = :reviewId", nativeQuery = true)
	void updateReview(@Param("reviewId") int reviewId, @Param("rating") double rating);

	@Query(value = "select * from review r join follow f on r.user_id = f.follow_user_id where f.user_id = :userId order by r.start_date", nativeQuery = true)
	List<Review> searchFeed(@Param("userId") long userId);


	public Optional<Review> findTopByBeerId(int beerId);

}