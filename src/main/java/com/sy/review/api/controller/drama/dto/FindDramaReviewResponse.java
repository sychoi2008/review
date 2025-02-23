package com.sy.review.api.controller.drama.dto;

import com.sy.review.domain.drama.DramaReview;
import lombok.Builder;

import java.util.List;

@Builder
public record FindDramaReviewResponse(List<FindDramaReviewResult> results) {
    public static FindDramaReviewResponse of(List<DramaReview> dramaReviews) {
        return new FindDramaReviewResponse(
                dramaReviews.stream()
                        .map(FindDramaReviewResult::of)
                        .toList()
        );
    }

    public record FindDramaReviewResult(
            Long dramaId,
            Long dramaReviewId,
            Long memberId,
            String dramaReviewTitle,
            String dramaTitle
    ) {
        public static FindDramaReviewResult of(DramaReview dramaReview) {
            return new FindDramaReviewResult(
                    dramaReview.getDrama().getDramaId(),
                    dramaReview.getId(),
                    dramaReview.getMember().getId(),
                    dramaReview.getTitle(),
                    dramaReview.getDrama().getTitle()
            );
        }
    }
}
