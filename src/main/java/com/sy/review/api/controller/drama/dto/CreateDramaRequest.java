package com.sy.review.api.controller.drama.dto;


import com.sy.review.api.service.drama.dto.CreateDramaServiceCommand;
import com.sy.review.domain.Channel;
import com.sy.review.domain.OTT;
import com.sy.review.domain.drama.DramaGenre;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class CreateDramaRequest {
    @NotNull(message = "필수값 입니다")
    @Schema(description = "드라마 제목", example = "응답하라 1992")
    private String title;

    @Schema(description = "드라마 감독", example = "신원호")
    private String director;

    @Schema(description = "드라마 장르", example = "ROMANCE")
    private DramaGenre dramaGenre;

    @Schema(description = "방영 시작일", example = "2013-10-18")
    private LocalDate releasedDate;

    @Schema(description = "방영화", example = "19")
    private Integer episodeCount;

    @Schema(description = "방영 플랫폼", example = "[\"NETFLIX\", \"TVING\"]")
    private Set<OTT> ottPlatforms;

    @Schema(description = "방영 채널", example = "[\"KBS\", \"SBS\"]")
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
