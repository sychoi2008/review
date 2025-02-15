package com.sy.review.api.service.drama.dto;

public record CreateDramaReviewServiceCommand(
        String title,
        String content,
        Integer rating,
        Long dramaId,
        Long memberId
) {}
