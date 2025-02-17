package com.sy.review.api.controller.drama;

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
    public void findAllDramaReviews() {

        // 4개 Drama Review
        // 영속성 컨텍스트 안에
        List<DramaReview> all = findDramaReviewService.findAllDramaReview();
        
        System.out.println(all);
    }
}
