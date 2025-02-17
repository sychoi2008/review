package com.sy.review.domain.drama;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DramaReviewRepository extends JpaRepository<DramaReview, Long> {
    @Query("SELECT dr FROM DramaReview dr JOIN FETCH dr.drama d JOIN FETCH dr.member m")
    List<DramaReview> findAllWithDramaAndMember();
}