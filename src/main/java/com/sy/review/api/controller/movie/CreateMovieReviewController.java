package com.sy.review.api.controller.movie;


import com.sy.review.api.controller.movie.dto.CreateMovieReviewRequest;
import com.sy.review.api.service.movie.CreateMovieReviewService;
import com.sy.review.api.service.movie.dto.CreateMovieReviewCommand;
import com.sy.review.domain.AuthUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Tag(name = "Create Movie Review", description = "영화 리뷰 생성")
@RestController
@RequestMapping("/api/movie/review")
public class CreateMovieReviewController {
    private final CreateMovieReviewService createMovieReviewService;

    @PostMapping
    public void createMovieReview(@RequestBody CreateMovieReviewRequest request) {
        createMovieReviewService.execute(
                CreateMovieReviewCommand.builder()
                        .title(request.title())
                        .movieId(request.movieId())
                        .content(request.content())
                        .memberId(AuthUtil.MASTER_USER_ID)
                        .rating(request.rating())
                        .build()
        );
    }
}
