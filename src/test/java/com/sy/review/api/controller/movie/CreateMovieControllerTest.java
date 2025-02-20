package com.sy.review.api.controller.movie;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sy.review.api.controller.movie.dto.CreateMovieRequest;
import com.sy.review.api.service.movie.CreateMovieService;
import com.sy.review.domain.Channel;
import com.sy.review.domain.OTT;
import com.sy.review.domain.movie.MovieGenre;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Set;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("local")
@WebMvcTest(CreateMovieController.class)
class CreateMovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CreateMovieService createMovieService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("영화 생성 API 테스트")
    void createDrama() throws Exception {
        // given
        CreateMovieRequest request = CreateMovieRequest.builder()
                .title("Inception")
                .director("Christopher Nolan")
                .movieGenre(MovieGenre.COMEDY)
                .releasedDate(LocalDate.of(2010, 7, 16))
                .ottPlatforms(Set.of(OTT.NETFLIX))
                .channelPlatforms(Set.of(Channel.KBS))
                .build();

        doNothing().when(createMovieService).execute(request.toServiceCommand());

        // when & then
        mockMvc.perform(post("/api/movie")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }
}
