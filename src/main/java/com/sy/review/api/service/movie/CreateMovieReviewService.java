package com.sy.review.api.service.movie;

import com.sy.review.api.service.movie.dto.CreateMovieReviewCommand;
import com.sy.review.domain.AuthUtil;
import com.sy.review.domain.member.Member;
import com.sy.review.domain.member.MemberRepository;
import com.sy.review.domain.movie.Movie;
import com.sy.review.domain.movie.MovieRepository;
import com.sy.review.domain.movie.MovieReview;
import com.sy.review.domain.movie.MovieReviewRepository;
import com.sy.review.domain.movie.exception.MovieNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateMovieReviewService {
    private final MovieReviewRepository movieReviewRepository;
    private final MovieRepository movieRepository;
    private final MemberRepository memberRepository;

    public void execute(CreateMovieReviewCommand command) {
        // 회원 찾기
        Member member = memberRepository.findById(AuthUtil.MASTER_USER_ID)
                .orElseThrow(() -> new EntityNotFoundException("user not found"));
        // 영화 찾기
        Movie movie = movieRepository.findById(command.movieId())
                .orElseThrow(() -> new MovieNotFoundException(command.movieId()));

        movieReviewRepository.save(
                MovieReview.builder()
                        .title(command.title())
                        .content(command.content())
                        .rating(command.rating())
                        .movie(movie)
                        .member(member)
                        .build()
        );
    }
}
