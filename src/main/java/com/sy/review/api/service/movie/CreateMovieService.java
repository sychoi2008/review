package com.sy.review.api.service.movie;


import com.sy.review.api.service.movie.dto.CreateMovieServiceCommand;
import com.sy.review.domain.drama.event.UpdatedDramaReviewEvent;
import com.sy.review.domain.movie.MovieRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateMovieService {
    private final MovieRepository movieRepository;

    public void execute(CreateMovieServiceCommand command) {
        movieRepository.save(command.toMovieEntity());
    }
}
