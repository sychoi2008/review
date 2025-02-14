package com.sy.review.api.service.drama;

import com.sy.review.api.service.drama.dto.CreateDramaReviewServiceCommand;
import com.sy.review.domain.AuthUtil;
import com.sy.review.domain.drama.Drama;
import com.sy.review.domain.drama.DramaRepository;
import com.sy.review.domain.drama.DramaReview;
import com.sy.review.domain.drama.DramaReviewRepository;
import com.sy.review.domain.member.Member;
import com.sy.review.domain.member.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateDramaReviewService {
    private final DramaReviewRepository dramaReviewRepository;
    private final DramaRepository dramaRepository;
    private final MemberRepository memberRepository;

    public void execute(CreateDramaReviewServiceCommand command) {
        Member member = memberRepository.findById(AuthUtil.MASTER_USER_ID)
                .orElseThrow(() -> new EntityNotFoundException("user not found"));
        Drama drama = dramaRepository.findById(command.getDramaId())
                .orElseThrow(() -> new EntityNotFoundException("drama not found"));

        dramaReviewRepository.save(
                DramaReview.builder()
                        .title(command.getTitle())
                        .content(command.getContent())
                        .rating(command.getRating())
                        .drama(drama)
                        .member(member)
                        .build()
        );
    }
}
