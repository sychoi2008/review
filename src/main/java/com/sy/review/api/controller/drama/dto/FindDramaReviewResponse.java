package com.sy.review.api.controller.drama.dto;

import com.sy.review.domain.drama.DramaReview;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public final class FindDramaReviewResponse {
    private List<FindDramaReviewResult> results;

    public static FindDramaReviewResponse of(List<DramaReview> dramaReviews) {
        return new FindDramaReviewResponse(
                dramaReviews.stream()
                        .map(FindDramaReviewResult::of)
                        .toList()
        );
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class FindDramaReviewResult {
        private Long dramaId;
        private Long dramaReviewId;
        private Long memberId;
        private String dramaReviewTitle;
        private String dramaTitle;

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
