package com.sy.review.domain.drama;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DramaReviewRepository extends JpaRepository<DramaReview, Long> {
    @Query("SELECT dr FROM DramaReview dr JOIN FETCH dr.drama d JOIN FETCH dr.member m")
    List<DramaReview> findAllWithDramaAndMember();

    @Modifying(clearAutomatically = true)
    @Query("UPDATE DramaReview dr SET dr.count = dr.count + 1 WHERE dr.id = :reviewId")
    int incrementCount(@Param("reviewId") Long reviewId);
}