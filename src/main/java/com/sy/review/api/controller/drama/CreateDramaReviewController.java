package com.sy.review.api.controller.drama;

import com.sy.review.api.controller.drama.dto.CreateDramaReviewRequest;
import com.sy.review.api.service.drama.CreateDramaReviewService;
import com.sy.review.api.service.drama.dto.CreateDramaReviewCommand;
import com.sy.review.domain.AuthUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Tag(name = "Create Drama Review", description = "드라마 리뷰 생성")
@RestController
@RequestMapping("/api/drama/review")
public class CreateDramaReviewController {
    private final CreateDramaReviewService createDramaReviewService;

    @PostMapping
    public void createDramaReview(@RequestBody CreateDramaReviewRequest request) {
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
