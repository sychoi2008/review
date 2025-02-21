package com.sy.review.api.service.drama;

import com.sy.review.api.service.drama.dto.UpdateDramaReviewCommand;
import com.sy.review.domain.drama.DramaReview;
import com.sy.review.domain.drama.DramaReviewRepository;
import com.sy.review.domain.drama.event.UpdatedDramaReviewEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class UpdateDramaReviewService {
    private final DramaReviewRepository dramaReviewRepository;
    private final ApplicationEventPublisher eventPublisher;

    public void execute(Long dramaReviewId, UpdateDramaReviewCommand command) {
        DramaReview dramaReview = dramaReviewRepository.findById(dramaReviewId).orElseThrow();
        dramaReview.update(command.content(), command.rating());

        eventPublisher.publishEvent(new UpdatedDramaReviewEvent(dramaReviewId));
    }
}
