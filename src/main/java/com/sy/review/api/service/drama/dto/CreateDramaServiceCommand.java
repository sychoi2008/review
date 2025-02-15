package com.sy.review.api.service.drama.dto;

import com.sy.review.domain.Channel;
import com.sy.review.domain.OTT;
import com.sy.review.domain.drama.Drama;
import com.sy.review.domain.drama.DramaGenre;
import lombok.Builder;

import java.time.LocalDate;
import java.util.Set;

@Builder
public record CreateDramaServiceCommand(
        String title,
        String director,
        DramaGenre dramaGenre,
        LocalDate releasedDate,
        Integer episodeCount,
        Set<OTT> ottPlatforms,
        Set<Channel> channelPlatforms
) {
    // 인스턴스 메서드
    public Drama toChangeEntity() {
        return Drama.builder()
                .title(this.title())
                .director(this.director())
                .dramaGenre(this.dramaGenre())
                .releasedDate(this.releasedDate())
                .episodeCount(this.episodeCount())
                .ottPlatforms(this.ottPlatforms())
                .channelPlatforms(this.channelPlatforms())
                .build();


    }
}
