package com.sy.review.api.controller.drama;

import com.sy.review.api.controller.drama.dto.FindDramaReviewResponse;
import com.sy.review.api.service.drama.FindDramaReviewService;
import com.sy.review.domain.drama.DramaReview;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/drama/review")
public class FindDramaReviewController {
    private final FindDramaReviewService findDramaReviewService;

    @GetMapping
    public FindDramaReviewResponse findAllDramaReviews() {
        List<DramaReview> dramaReviews = findDramaReviewService.findAllDramaReview();
        return FindDramaReviewResponse.of(dramaReviews);
    }
}