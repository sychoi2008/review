package com.sy.review.api.controller.drama;

import com.sy.review.api.controller.drama.dto.CreateDramaReviewRequest;
import com.sy.review.api.service.drama.CreateDramaReviewService;
import com.sy.review.api.service.drama.dto.CreateDramaReviewCommand;
import com.sy.review.domain.AuthUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/drama/review")
public class CreateDramaReviewController {
    private final CreateDramaReviewService createDramaReviewService;

    @PostMapping
    public void createDramaReview(CreateDramaReviewRequest request) {
        createDramaReviewService.execute(
                CreateDramaReviewCommand.builder()
                        .title(request.title())
                        .dramaId(request.dramaId())
                        .content(request.content())
                        .memberId(AuthUtil.MASTER_USER_ID)
                        .rating(request.rating())
                        .build()
        );
    }
}
