package com.sy.review.api.service.drama.dto;

import com.sy.review.domain.Channel;
import com.sy.review.domain.OTT;
import com.sy.review.domain.drama.Drama;
import com.sy.review.domain.drama.DramaGenre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class CreateDramaServiceCommand {
    private String title;

    private String director;

    private DramaGenre dramaGenre;

    private LocalDate releasedDate;

    private Integer episodeCount;

    private Set<OTT> ottPlatforms;

    private Set<Channel> channelPlatforms;

    // 인스턴스 메서드
    public Drama toChangeEntity() {
        return Drama.builder()
                .title(this.getTitle())
                .director(this.getDirector())
                .dramaGenre(this.getDramaGenre())
                .releasedDate(this.getReleasedDate())
                .episodeCount(this.getEpisodeCount())
                .ottPlatforms(this.getOttPlatforms())
                .channelPlatforms(this.getChannelPlatforms())
                .build();


    }
}
