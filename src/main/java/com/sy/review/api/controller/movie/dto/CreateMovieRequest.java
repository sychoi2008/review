package com.sy.review.api.controller.movie.dto;

import com.sy.review.api.service.movie.dto.CreateMovieCommand;
import com.sy.review.domain.Channel;
import com.sy.review.domain.OTT;
import com.sy.review.domain.movie.MovieGenre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
public class CreateMovieRequest {
    private String title;

    private String director;

    private MovieGenre movieGenre;

    private LocalDate releasedDate;

    private Set<OTT> ottPlatforms;

    private Set<Channel> channelPlatforms;

    public CreateMovieCommand toServiceCommand() {
        return CreateMovieCommand.builder()
                .title(title)
                .director(director)
                .movieGenre(movieGenre)
                .ottPlatforms(ottPlatforms)
                .channelPlatforms(channelPlatforms)
                .build();
    }
}
