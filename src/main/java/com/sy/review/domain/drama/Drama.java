package com.sy.review.domain.drama;

import com.sy.review.domain.Channel;
import com.sy.review.domain.ChannelSetConverter;
import com.sy.review.domain.OTT;
import com.sy.review.domain.OTTSetConverter;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
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

//    @ElementCollection
//    @Enumerated(EnumType.STRING)
//    @CollectionTable(name = "drama_ott", joinColumns = @JoinColumn(name = "drama_id"))
//    @Column(name = "ott")
//    private Set<OTT> ottPlatforms = new HashSet<>();
//
//    @ElementCollection
//    @Enumerated(EnumType.STRING)
//    @CollectionTable(name = "drama_channel", joinColumns = @JoinColumn(name = "drama_id"))
//    @Column(name = "channel")
//    private Set<Channel> channelPlatforms = new HashSet<>();

    @Convert(converter = OTTSetConverter.class)
    @Column(columnDefinition = "TEXT")
    private Set<OTT> ottPlatforms = new HashSet<>();

    @Convert(converter = ChannelSetConverter.class)
    @Column(columnDefinition = "TEXT")
    private Set<Channel> channelPlatforms = new HashSet<>();

}
