package com.sy.review.api.controller.movie;

import com.sy.review.api.controller.movie.dto.CreateMovieRequest;
import com.sy.review.api.service.movie.CreateMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/movie")
public class CreateMovieController {
    private final CreateMovieService createMovieService;

    @PostMapping
    public void createMovie(@RequestBody CreateMovieRequest request) {
        createMovieService.execute(request.toServiceCommand());
    }
}