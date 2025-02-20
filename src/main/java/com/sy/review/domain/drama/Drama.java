package com.sy.review.domain.drama;

import com.sy.review.domain.Channel;
import com.sy.review.domain.ChannelSetConverter;
import com.sy.review.domain.OTT;
import com.sy.review.domain.OTTSetConverter;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Drama {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dramaId;

    private String title;

    private String director;

    @Enumerated(EnumType.STRING)
    private DramaGenre dramaGenre;

    private LocalDate releasedDate;

    private Integer episodeCount;

    @Convert(converter = OTTSetConverter.class)
    private Set<OTT> ottPlatforms = new HashSet<>();

    @Convert(converter = ChannelSetConverter.class)
    private Set<Channel> channelPlatforms = new HashSet<>();

    @Builder
    public Drama(Set<Channel> channelPlatforms, Set<OTT> ottPlatforms, Integer episodeCount, LocalDate releasedDate, DramaGenre dramaGenre, String director, String title, Long dramaId) {
        this.channelPlatforms = channelPlatforms;
        this.ottPlatforms = ottPlatforms;
        this.episodeCount = episodeCount;
        this.releasedDate = releasedDate;
        this.dramaGenre = dramaGenre;
        this.director = director;
        this.title = title;
        this.dramaId = dramaId;
    }
}
