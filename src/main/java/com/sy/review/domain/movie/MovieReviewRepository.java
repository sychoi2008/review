package com.sy.review.domain.movie;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieReviewRepository extends JpaRepository<MovieReview, Long> {
}
