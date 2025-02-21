package com.sy.review.api.service.drama;

import com.sy.review.domain.AuthUtil;
import com.sy.review.domain.drama.DramaReview;
import com.sy.review.domain.drama.DramaReviewLike;
import com.sy.review.domain.drama.DramaReviewLikeRepository;
import com.sy.review.domain.drama.DramaReviewRepository;
import com.sy.review.domain.member.Member;
import com.sy.review.domain.member.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class DramaReviewLikeService {
    private final MemberRepository memberRepository;
    private final DramaReviewRepository dramaReviewRepository;
    private final DramaReviewLikeRepository dramaReviewLikeRepository;

    public void like(Long memberId, Long dramaReviewId) {
        Member member = memberRepository.findById(AuthUtil.MASTER_USER_ID)
                .orElseThrow(() -> new EntityNotFoundException("user not found"));

        DramaReview dramaReview = dramaReviewRepository.findById(dramaReviewId)
                .orElseThrow(() -> new EntityNotFoundException("dramaReview not found"));

        dramaReviewLikeRepository.save(DramaReviewLike.builder()
                        .member(member)
                        .dramaReview(dramaReview)
                .build());

        dramaReviewRepository.incrementCount(dramaReviewId);
    }
}
