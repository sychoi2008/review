package com.sy.review.domain.movie.exception;

import com.sy.review.domain.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class MovieNotFoundException extends BusinessException {
    public MovieNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND, "없는 영화입니다. ID : %d".formatted(id));
    }
}
