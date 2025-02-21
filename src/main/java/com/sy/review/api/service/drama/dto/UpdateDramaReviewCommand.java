package com.sy.review.api.service.drama.dto;

public record UpdateDramaReviewCommand(
        String content,
        Integer rating
) {}
