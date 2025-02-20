package com.sy.review.api.controller.drama;

import com.sy.review.api.service.drama.FindDramaReviewService;
import com.sy.review.domain.drama.Drama;
import com.sy.review.domain.drama.DramaReview;
import com.sy.review.domain.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("local")
@WebMvcTest(FindDramaReviewController.class)
class FindDramaReviewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private FindDramaReviewService findDramaReviewService;

    @Test
    @DisplayName("드라마 리뷰 목록을 조회한다")
    void findAllDramaReviews() throws Exception {
        // Given
        Drama drama = Drama.builder()
                .dramaId(1L)
                .title("별에서온그대")
                .build();

        Member member = Member.builder()
                .id(1L)
                .name("김수현")
                .build();

        DramaReview dramaReview = DramaReview.builder()
                .id(1L)
                .drama(drama)
                .member(member)
                .content("온그대")
                .build();

        List<DramaReview> dramaReviews = List.of(dramaReview);

        when(findDramaReviewService.findAllDramaReview()).thenReturn(dramaReviews);

        // When & Then
        mockMvc.perform(get("/api/drama/review"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(jsonPath("$.results[0].dramaId").value(drama.getDramaId()))
                .andExpect(jsonPath("$.results[0].dramaReviewId").value(dramaReview.getId()))
                .andExpect(jsonPath("$.results[0].memberId").value(member.getId()))
                .andExpect(jsonPath("$.results[0].dramaReviewTitle").value(dramaReview.getTitle()))
                .andExpect(jsonPath("$.results[0].dramaTitle").value(drama.getTitle()));
    }
}