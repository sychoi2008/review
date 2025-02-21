package com.sy.review.api.service.movie.dto;

import lombok.Builder;

@Builder
public record CreateMovieReviewCommand(
        String title,
        String content,
        Integer rating,
        Long movieId,
        Long memberId
) {
}
