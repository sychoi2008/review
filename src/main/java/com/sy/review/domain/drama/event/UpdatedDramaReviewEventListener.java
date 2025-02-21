package com.sy.review.domain.drama.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class UpdatedDramaReviewEventListener {

    @EventListener
    public void handleEvent(UpdatedDramaReviewEvent event) {
        log.info("updated ID : {}", event.getUpdatedDramaReviewId());
    }
}
