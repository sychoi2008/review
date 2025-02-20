package com.sy.review.api.controller.drama.dto;

public record CreateDramaReviewRequest(
        String title,
        String content,
        Integer rating,
        Long dramaId,
        Long memberId
) {}
