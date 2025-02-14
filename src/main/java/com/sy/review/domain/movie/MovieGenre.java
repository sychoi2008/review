package com.sy.review.domain.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MovieGenre {
    ROMANCE("로맨스"),
    HORROR("호러"),
    COMEDY("코미디"),
    ;

    private final String message;
}
