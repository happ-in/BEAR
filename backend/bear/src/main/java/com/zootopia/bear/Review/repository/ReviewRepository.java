package com.zootopia.bear.Review.repository;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zootopia.bear.Review.domain.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
	List<Review> findAllByUserId(long userId);

	List<Review> findAllByUserIdOrderByStartDateDesc(long userId);

	@Query(value = "select sum(rating)/count(*) from review where beer_id=:beerId group by beer_id;", nativeQuery = true)
	Optional<Double> beerAvg(@Param("beerId") int beerId);

	@Modifying(clearAutomatically = true)
	@Query(value = "update review set rating = :rating where review_id = :reviewId", nativeQuery = true)
	void updateReview(@Param("reviewId") int reviewId, @Param("rating") double rating);

	@Query(value = "select * from review r join follow f on r.user_id = f.follow_user_id where f.user_id = :userId order by r.start_date desc", nativeQuery = true)
	List<Review> searchFeed(@Param("userId") long userId);

	Optional<Review> findByBeerId(int beerId);
}