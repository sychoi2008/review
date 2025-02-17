package com.sy.review.api.service.drama;

import com.sy.review.api.service.drama.dto.CreateDramaReviewCommand;
import com.sy.review.domain.AuthUtil;
import com.sy.review.domain.drama.Drama;
import com.sy.review.domain.drama.DramaRepository;
import com.sy.review.domain.drama.DramaReview;
import com.sy.review.domain.drama.DramaReviewRepository;
import com.sy.review.domain.drama.exception.DramaNotFoundException;
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

    public void execute(CreateDramaReviewCommand command) {
        Member member = memberRepository.findById(AuthUtil.MASTER_USER_ID)
                .orElseThrow(() -> new EntityNotFoundException("user not found"));
        Drama drama = dramaRepository.findById(command.dramaId())
                .orElseThrow(() -> new DramaNotFoundException(command.dramaId()));

        dramaReviewRepository.save(
                DramaReview.builder()
                        .title(command.title())
                        .content(command.content())
                        .rating(command.rating())
                        .drama(drama)
                        .member(member)
                        .build()
        );
    }
}
