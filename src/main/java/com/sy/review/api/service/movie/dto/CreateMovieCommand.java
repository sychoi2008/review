package com.sy.review.api.service.movie.dto;

import com.sy.review.domain.Channel;
import com.sy.review.domain.OTT;
import com.sy.review.domain.movie.Movie;
import com.sy.review.domain.movie.MovieGenre;
import lombok.Builder;

import java.time.LocalDate;
import java.util.Set;

@Builder
public record CreateMovieCommand(
        Long movieId,
        String title,
        String director,
        MovieGenre movieGenre,
        LocalDate releasedDate,
        Set<OTT> ottPlatforms,
        Set<Channel> channelPlatforms
) {
    public Movie toMovieEntity() {
        return Movie.builder()
                .title(this.title())
                .director(this.director())
                .movieGenre(this.movieGenre())
                .releasedDate(this.releasedDate())
                .ottPlatforms(this.ottPlatforms())
                .channelPlatforms(this.channelPlatforms())
                .build();
    }
}
