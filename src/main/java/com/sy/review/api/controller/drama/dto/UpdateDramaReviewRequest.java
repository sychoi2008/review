package com.sy.review.api.controller.drama.dto;

import com.sy.review.api.service.drama.dto.UpdateDramaReviewCommand;

public record UpdateDramaReviewRequest(
        String content,
        Integer rating
) {
    public UpdateDramaReviewCommand toUpdateCommand() {
        return new UpdateDramaReviewCommand(content, rating);
    }
}
