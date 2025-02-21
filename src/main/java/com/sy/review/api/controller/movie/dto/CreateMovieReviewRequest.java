package com.sy.review.api.controller.movie.dto;

public record CreateMovieReviewRequest(
        String title,
        String content,
        Integer rating,
        Long movieId,
        Long memberId
) {
}
