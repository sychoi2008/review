package com.sy.review.api.service.drama;

import com.sy.review.domain.drama.DramaRepository;
import com.sy.review.domain.drama.DramaReview;
import com.sy.review.domain.drama.DramaReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FindDramaReviewService {
    private final DramaReviewRepository dramaReviewRepository;

    public List<DramaReview> findAllDramaReview() {
        return dramaReviewRepository.findAll();
    }
}
