package com.sy.review.domain;

import com.sy.review.domain.drama.*;
import com.sy.review.domain.member.Member;
import com.sy.review.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataInitService {
    private final DramaReviewRepository dramaReviewRepository;
    private final DramaRepository dramaRepository;
    private final MemberRepository memberRepository;

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void initData() {
        Member member = memberRepository.findById(AuthUtil.MASTER_USER_ID).orElseThrow();

        Drama drama1 = Drama.builder()
                .title("t1")
                .director("drama1")
                .dramaGenre(DramaGenre.COMEDY)
                .channelPlatforms(Set.of(Channel.MBC))
                .releasedDate(LocalDate.now())
                .episodeCount(10)
                .build();

        Drama drama2 = Drama.builder()
                .title("t2")
                .director("drama2")
                .dramaGenre(DramaGenre.COMEDY)
                .channelPlatforms(Set.of(Channel.MBC))
                .releasedDate(LocalDate.now())
                .episodeCount(10)
                .build();

        dramaRepository.saveAll(List.of(drama1, drama2));

        DramaReview dramaReview1 = create("title1", "content1",  drama1, member);
        DramaReview dramaReview2 = create("title2", "content2",  drama1, member);
        DramaReview dramaReview3 = create("title3", "content3",  drama2, member);
        DramaReview dramaReview4 = create("title4", "content4",  drama2, member);

        dramaReviewRepository.saveAll(List.of(dramaReview1, dramaReview2, dramaReview3, dramaReview4));
    }

    public DramaReview create(String title, String content, Drama drama, Member member) {
        return DramaReview.builder()
                .title(title)
                .content(content)
                .rating(3)
                .drama(drama)
                .member(member).build();
    }
}
