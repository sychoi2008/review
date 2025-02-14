package com.sy.review.api.controller.drama.dto;


import com.sy.review.api.service.drama.dto.CreateDramaServiceCommand;
import com.sy.review.domain.Channel;
import com.sy.review.domain.OTT;
import com.sy.review.domain.drama.DramaGenre;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class CreateDramaRequest {
    private String title;

    private String director;

    private DramaGenre dramaGenre;

    private LocalDate releasedDate;

    private Integer episodeCount;

    private Set<OTT> ottPlatforms;

    private Set<Channel> channelPlatforms;

    public CreateDramaServiceCommand toServiceCommand() {
        return CreateDramaServiceCommand.builder()
                .title(title)
                .director(director)
                .dramaGenre(dramaGenre)
                .releasedDate(releasedDate)
                .episodeCount(episodeCount)
                .channelPlatforms(channelPlatforms)
                .ottPlatforms(ottPlatforms)
                .build();
    }
}
