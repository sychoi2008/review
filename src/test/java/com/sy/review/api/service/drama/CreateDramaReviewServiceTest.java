package com.sy.review.api.service.drama;

import com.sy.review.api.service.drama.dto.CreateDramaReviewServiceCommand;
import com.sy.review.domain.AuthUtil;
import com.sy.review.domain.drama.Drama;
import com.sy.review.domain.drama.DramaRepository;
import com.sy.review.domain.drama.DramaReview;
import com.sy.review.domain.drama.DramaReviewRepository;
import com.sy.review.domain.member.Member;
import com.sy.review.domain.member.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import java.util.Optional;

import static org.mockito.BDDMockito.given;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateDramaReviewServiceTest {
    @InjectMocks
    CreateDramaReviewService sut;

    @Mock
    DramaReviewRepository dramaReviewRepository;

    @Mock
    DramaRepository dramaRepository;

    @Mock
    MemberRepository memberRepository;

    @Test
    void 리뷰_생성_성공() {
        // given
        CreateDramaReviewServiceCommand command = new CreateDramaReviewServiceCommand(
                "TITLE",
                "CONTENT",
                5,
                1L,
                1L
        );
        Drama mockDrama = Mockito.mock(Drama.class);
        Member mockMember = Mockito.mock(Member.class);
        DramaReview mockDramaReview = Mockito.mock(DramaReview.class);

        given(dramaRepository.findById(any())).willReturn(Optional.of(mockDrama));
        given(memberRepository.findById(any())).willReturn(Optional.of(mockMember));
        given(dramaReviewRepository.save(any(DramaReview.class))).willReturn(mockDramaReview);

        // when
        sut.execute(command);

        // then
        verify(memberRepository, times(1)).findById(AuthUtil.MASTER_USER_ID);
        verify(dramaRepository, times(1)).findById(1L);
        verify(dramaReviewRepository, times(1)).save(any(DramaReview.class));
    }

}