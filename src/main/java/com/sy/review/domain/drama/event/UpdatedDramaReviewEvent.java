package com.sy.review.domain.drama.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UpdatedDramaReviewEvent {
    private Long updatedDramaReviewId;
}
