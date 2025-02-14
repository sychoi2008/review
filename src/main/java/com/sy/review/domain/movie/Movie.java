package com.sy.review.domain.movie;

import com.sy.review.domain.Channel;
import com.sy.review.domain.ChannelSetConverter;
import com.sy.review.domain.OTT;
import com.sy.review.domain.OTTSetConverter;
import com.sy.review.domain.drama.DramaGenre;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    private String title;
    
    private String director;

    @Enumerated(EnumType.STRING)
    private MovieGenre movieGenre;

    private LocalDate releasedDate;

    @Convert(converter = OTTSetConverter.class)
    private Set<OTT> ottPlatforms = new HashSet<>();

    @Convert(converter = ChannelSetConverter.class)
    private Set<Channel> channelPlatforms = new HashSet<>();
    
}
