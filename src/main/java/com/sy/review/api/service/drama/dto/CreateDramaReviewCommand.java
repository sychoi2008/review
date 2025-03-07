package com.sy.review.api.service.drama.dto;

import lombok.Builder;

@Builder
public record CreateDramaReviewCommand(
        String title,
        String content,
        Integer rating,
        Long dramaId,
        Long memberId
) {}
