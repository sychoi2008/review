package com.sy.review.api.service.drama.dto;

import com.sy.review.domain.drama.DramaReview;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CreateDramaReviewServiceCommand {
    private String title;

    private String content;

    private Integer rating;

    private Long dramaId;

    private Long memberId;


}
