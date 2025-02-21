package com.sy.review.api.controller.drama;

import com.sy.review.api.controller.drama.dto.UpdateDramaReviewRequest;
import com.sy.review.api.service.drama.UpdateDramaReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/drama")
public class UpdateDramaReviewController {
    private final UpdateDramaReviewService updateDramaReviewService;

    @PutMapping("/{dramaReviewId}")
    public void update(@PathVariable Long dramaReviewId, @RequestBody UpdateDramaReviewRequest request) {
        updateDramaReviewService.execute(dramaReviewId, request.toUpdateCommand());
    }
}
