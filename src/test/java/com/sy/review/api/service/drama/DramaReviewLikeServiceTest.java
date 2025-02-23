package com.sy.review.api.service.drama;

import com.sy.review.domain.Channel;
import com.sy.review.domain.drama.*;
import com.sy.review.domain.member.Member;
import com.sy.review.domain.member.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Set;

@EnableJpaAuditing
@SpringBootTest
@Transactional
class DramaReviewLikeServiceTest {
    @Autowired
    DramaReviewLikeService dramaReviewLikeService;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    DramaReviewRepository dramaReviewRepository;

    @Autowired
    DramaRepository dramaRepository;

    private Member member;
    private DramaReview dramaReview;
    private Drama drama;

    @Test
    public void like() {
        member = memberRepository.findById(1L).orElseThrow();
        drama = dramaRepository.save(Drama.builder()
                .title("t2")
                .director("drama2")
                .dramaGenre(DramaGenre.COMEDY)
                .channelPlatforms(Set.of(Channel.MBC))
                .releasedDate(LocalDate.now())
                .episodeCount(10)
                .build());
        dramaReview = dramaReviewRepository.save(DramaReview.builder()
                .drama(drama)
                .member(member)
                .content("온그대")
                .build());

        dramaReviewLikeService.like(1L, dramaReview.getId());

        DramaReview find = dramaReviewRepository.findById(dramaReview.getId()).orElseThrow();
        Assertions.assertEquals(find.getCount(), 1);
    }
}